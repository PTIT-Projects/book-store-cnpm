/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.ptit.cnpm.group11.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author duongvct
 */
public class ImportBill {
    private int id;
    private long totalAmount;
    private LocalDate importDate;
    private int saleOff;
    private String paymentMethod;
    private String note;
    private Provider provider;
    private User user;
    private ArrayList<ImportedBookTitle> importedBookTitleList;

    
    public ImportBill() {
        this.importedBookTitleList = new ArrayList<>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public int getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(int saleOff) {
        this.saleOff = saleOff;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<ImportedBookTitle> getImportedBookTitleList() {
        return importedBookTitleList;
    }

    public void setImportedBookTitleList(ArrayList<ImportedBookTitle> importedBookTitleList) {
        this.importedBookTitleList = importedBookTitleList;
    }
    
    public long getTotalAmount() {
        long res = 0;
        for (ImportedBookTitle ibt : importedBookTitleList) {
            res += ibt.getAmount();
        }
        return res - saleOff;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ImportBill that)) return false;
        return id == that.id && totalAmount == that.totalAmount && saleOff == that.saleOff && Objects.equals(importDate, that.importDate) && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(note, that.note) && Objects.equals(provider, that.provider) && Objects.equals(user, that.user) && Objects.equals(importedBookTitleList, that.importedBookTitleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalAmount, importDate, saleOff, paymentMethod, note, provider, user, importedBookTitleList);
    }
}
