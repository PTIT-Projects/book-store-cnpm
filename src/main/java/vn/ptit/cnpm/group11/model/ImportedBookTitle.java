/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.ptit.cnpm.group11.model;

/**
 *
 * @author duongvct
 */
public class ImportedBookTitle {
    private int id;
    private int quantity;
    private long amount;
    private int unitPrice;
    private BookTitle bookTitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getAmount() {
        return unitPrice * quantity;
    }


    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BookTitle getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(BookTitle bookTitle) {
        this.bookTitle = bookTitle;
    }
    
}
