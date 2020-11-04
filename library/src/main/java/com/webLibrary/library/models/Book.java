package com.webLibrary.library.models;
import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String nameOfAutor;
    private String discription;


    public Book(String title, String nameOfAutor, String discription) {
        this.title = title;
        this.nameOfAutor = nameOfAutor;
        this.discription = discription;
    }
    public Book(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameOfAutor() {
        return nameOfAutor;
    }

    public void setNameOfAutor(String nameOfAutor) {
        this.nameOfAutor = nameOfAutor;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
