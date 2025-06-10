package com.example.BookTracker.model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String author;
    private boolean isRead;

    public Book() {} // JPA için boş constructor

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isRead = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return id + ". " + title + " - " + author + (isRead ? " [OKUNDU]" : " [OKUNMADI]");
    }
}
