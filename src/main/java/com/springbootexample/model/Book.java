package com.springbootexample.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@NamedQueries(value = {
        @NamedQuery(query = "Select b from Book b", name = "Book.findBooks"),
        @NamedQuery(name = "Book.categories", query = "select b.id, b.name, bCat.name from Book b left outer join BookCategory bCat on b.bookCategory = bCat.id"),
        @NamedQuery(name = "Book.findBookbyId", query = "select b from Book b where b.id = :id"),
        @NamedQuery(name = "Book.findBookbyName", query = "select b from Book b where b.name = ?1"),
        @NamedQuery(name = "Book.findBookUsingLike", query = "select b from Book b where b.name like CONCAT(:name,'%')")
})
public class Book {
    private int id;
    private String name;
    private BookCategory bookCategory;

    public Book() {

    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, BookCategory bookCategory) {
        this.name = name;
        this.bookCategory = bookCategory;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "book_category_id")
    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}