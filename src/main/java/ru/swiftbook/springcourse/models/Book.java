package ru.swiftbook.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Book {

    private int id;

    @NotEmpty(message = "Name should not be empty")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    private String author;

    @Min(value = 1, message = "Year should be greater then 1")
    private int year;

    private Integer personId;

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
