package model;

public class Novel extends Book{
    private String id;
    private String title;
    private String publisher;
    private Integer yearPublished;
    private String author;

    public Novel(int id, String title, String publisher, Integer yearPublished, String author) {
        this.title = title;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.author = author;
        this.id = String.format("%d-A-%d", this.yearPublished, id);
    }


    public String getId() {
        return id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return String.format("Title = %s {id: %s, publisher: %s, yearPublished: %d, author: %s}"
                ,title, id, publisher, yearPublished, author);
    }
}
