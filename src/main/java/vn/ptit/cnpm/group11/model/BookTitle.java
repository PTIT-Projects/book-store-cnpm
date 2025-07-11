/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.ptit.cnpm.group11.model;

import java.util.Objects;

/**
 *
 * @author duongvct
 */
public class BookTitle {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private int publicationYear;
    private int unitPrice;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookTitle bookTitle)) return false;
        return publicationYear == bookTitle.publicationYear && unitPrice == bookTitle.unitPrice && Objects.equals(name, bookTitle.name) && Objects.equals(author, bookTitle.author) && Objects.equals(publisher, bookTitle.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, publisher, publicationYear, unitPrice);
    }
}
