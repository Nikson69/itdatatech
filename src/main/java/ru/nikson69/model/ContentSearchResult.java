package ru.nikson69.model;

import java.util.List;

public class ContentSearchResult {
    public List<Content> contents;
    public Integer pages;
    public Integer current;

    public ContentSearchResult(){
        this.contents = null;
        this.pages = null;
    }

    public ContentSearchResult(List<Content> contents,Integer pages,Integer current){
        this.contents = contents;
        this.pages = pages;
        this.current = current;
    }
}
