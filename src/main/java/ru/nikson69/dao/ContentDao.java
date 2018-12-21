package ru.nikson69.dao;

import ru.nikson69.model.Content;
import ru.nikson69.model.ContentSearchParametrs;

import java.util.List;

public interface ContentDao {

    Content findById(int id);

    List<Content> findByParams(ContentSearchParametrs contentSearchParametrs);

    Integer countByParams(ContentSearchParametrs contentSearchParametrs);

    void saveContent(Content content);

    void updateContent(Content content);

    void  deleteById(int id);

}
