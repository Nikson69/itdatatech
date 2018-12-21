package ru.nikson69.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContentSearchParametrs {
    public static final Integer GETLIST_DEFAULT_COUNT = 9;

    public Integer getCount() {
        return count;
    }

    public Integer getPage() {
        return page;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategories() {
        return categories;
    }

    public Date getCreatedBefore() {
        return createdBefore;
    }

    public Date getCreatedAfter() {
        return createdAfter;
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getTo() {
        return to;
    }

    private final Integer count;
    private final Integer from;
    private final Integer to;
    private final Integer page;
    private final String name;
    private final String description;
    private final String categories;
    private final Date createdBefore;
    private final Date createdAfter;

    public static class Builder {
        private Integer count;
        private Integer page;
        private String name;
        private String description;
        private String categories;
        private Date createdBefore;
        private Date createdAfter;

        private final DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        public Builder() {
        }

        public Builder count(Integer val) {
            count = val;
            return this;
        }

        public Builder page(Integer val) {
            page = val;
            return this;
        }

        public Builder name(String val) {

            name = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder categories(String val) {
            categories = val;
            return this;
        }

        public Builder createdBefore(Date val) {
            createdBefore = val;
            return this;
        }

        public Builder createdAfter(Date val) {
            createdAfter = val;
            return this;
        }

        public Builder createdBefore(String val) throws ParseException {
            if (val != null)
                return this.createdBefore(format.parse(val));
            createdBefore = null;
            return this;
        }

        public Builder createdAfter(String val) throws ParseException {
            if (val != null)
                return this.createdAfter(format.parse(val));
            createdAfter = null;
            return this;
        }

        public ContentSearchParametrs build() {
            return new ContentSearchParametrs(this);
        }
    }

    private ContentSearchParametrs(Builder builder) {
        count = builder.count == null ? GETLIST_DEFAULT_COUNT : builder.count;
        page = builder.page == null ? 1 : builder.page;
        from = (page - 1) * count;
        to = page * count -1 ;
        name = builder.name;
        description = builder.description;
        categories = builder.categories;
        createdBefore = builder.createdBefore;
        createdAfter = builder.createdAfter;
    }

}
