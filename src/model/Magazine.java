package model;

import utility.PublishPeriod;

import java.util.ArrayList;

public class Magazine extends Book{
    private String id ;
    private String title;
    private PublishPeriod publishPeriod;
    private Integer yearPublished;

    public Magazine(int id, String title, PublishPeriod publishPeriod, Integer yearPublished) {
        this.title = title;
//        this.publishPeriod = PublishPeriod.valueOf(publishPeriod);
        this.publishPeriod = publishPeriod;
        this.yearPublished = yearPublished;
        this.id = String.format("%d-B-%d", this.yearPublished, id);
    }


    public String getId() {
        return id;
    }

    public PublishPeriod getPublishPeriod() {
        return publishPeriod;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return String.format("Title = %s {id: %s, publishPeriod: %s, yearPublished: %d}"
                ,title, id, publishPeriod, yearPublished);
    }

}
