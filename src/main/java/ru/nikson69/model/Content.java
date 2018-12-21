package ru.nikson69.model;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Content implements Serializable {

    private Integer id;

    private String name;

    private String description;

    private String path;

    private String categories;

    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", path='" + path + '\'' +
                ", categories='" + categories + '\'' +
                ", created='" + created + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content = (Content) o;
        return Objects.equals(id, content.id) &&
                Objects.equals(name, content.name) &&
                Objects.equals(description, content.description) &&
                Objects.equals(path, content.path) &&
                Objects.equals(categories, content.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, path, categories);
    }


}
