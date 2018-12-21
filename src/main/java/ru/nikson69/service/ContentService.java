package ru.nikson69.service;

import ru.nikson69.model.Content;
import ru.nikson69.model.ContentSearchParametrs;
import ru.nikson69.model.ContentSearchResult;


public interface ContentService {

    Content findById(int id);

    ContentSearchResult findByParams(ContentSearchParametrs contentSearchParametrs);

    void saveContent(Content content);

    void updateContent(Content content);

    void  deleteById(int id);
}
