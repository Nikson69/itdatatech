package ru.nikson69.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import ru.nikson69.dao.ContentDao;
import ru.nikson69.model.Content;
import ru.nikson69.model.ContentSearchParametrs;
import ru.nikson69.model.ContentSearchResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Service("contentService")
@Transactional
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentDao dao;

    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public Content findById(int id) {
        return dao.findById(id);
    }

    @Override
    public ContentSearchResult findByParams(ContentSearchParametrs contentSearchParametrs) {
        Integer count = dao.countByParams(contentSearchParametrs);
        Integer chunk = contentSearchParametrs.getCount();
        Integer pages = count/chunk+ (count%chunk>0?1:0);
        return new ContentSearchResult(dao.findByParams(contentSearchParametrs), pages, contentSearchParametrs.getPage());
    }



    @Override
    public void saveContent(Content content) {
        dao.saveContent(content);
    }

    @Override
    public void updateContent(Content content) {
        dao.updateContent(content);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
