package vn.ptit.cnpm.group11.dao;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vn.ptit.cnpm.group11.model.*;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;

public class ImportBillDAOTest {
    private final ImportBillDAO importBillDAO;

    public ImportBillDAOTest() {
        importBillDAO = new ImportBillDAO();
    }
    @Test
    public void testAddImportBillException1() {
        // not exist provider, exist booktitle
        ImportBill importBill = new ImportBill();
        importBill.setSaleOff(0);
        importBill.setImportDate(LocalDate.now());
        importBill.setPaymentMethod("Tiền mặt");

        User user = new User();
        user.setId(1);

        Provider provider = new Provider();
        provider.setId(10);

        importBill.setUser(user);
        importBill.setProvider(provider);

        BookTitle bookTitle = new BookTitle();
        bookTitle.setId(1);
        ImportedBookTitle ibt = new ImportedBookTitle();
        ibt.setBookTitle(bookTitle);
        ibt.setQuantity(20);
        ibt.setUnitPrice(30000);

        BookTitle bookTitle1 = new BookTitle();
        bookTitle1.setId(2);
        ImportedBookTitle ibt1 = new ImportedBookTitle();
        ibt1.setBookTitle(bookTitle1);
        ibt1.setQuantity(20);
        ibt1.setUnitPrice(30000);

        ArrayList<ImportedBookTitle> ibts = new ArrayList<>();
        ibts.add(ibt);
        ibts.add(ibt1);

        importBill.setImportedBookTitleList(ibts);

        Connection connection = DAO.getConnection();
        try{
            connection.setAutoCommit(false);
            Assertions.assertFalse(importBillDAO.confirmImportBookTitle(importBill));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(!connection.getAutoCommit()) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    @Test
    public void testAddImportBillException2() {
        //  exist provider, not exist booktitle
        ImportBill importBill = new ImportBill();
        importBill.setSaleOff(0);
        importBill.setImportDate(LocalDate.now());
        importBill.setPaymentMethod("Tiền mặt");

        User user = new User();
        user.setId(1);

        Provider provider = new Provider();
        provider.setId(1);

        importBill.setUser(user);
        importBill.setProvider(provider);

        BookTitle bookTitle = new BookTitle();
        bookTitle.setId(100);
        ImportedBookTitle ibt = new ImportedBookTitle();
        ibt.setBookTitle(bookTitle);
        ibt.setQuantity(20);
        ibt.setUnitPrice(30000);

        BookTitle bookTitle1 = new BookTitle();
        bookTitle1.setId(200);
        ImportedBookTitle ibt1 = new ImportedBookTitle();
        ibt1.setBookTitle(bookTitle1);
        ibt1.setQuantity(20);
        ibt1.setUnitPrice(30000);

        ArrayList<ImportedBookTitle> ibts = new ArrayList<>();
        ibts.add(ibt);
        ibts.add(ibt1);

        importBill.setImportedBookTitleList(ibts);

        Connection connection = DAO.getConnection();
        try{
            connection.setAutoCommit(false);
            Assertions.assertFalse(importBillDAO.confirmImportBookTitle(importBill));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(!connection.getAutoCommit()) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }

    @Test
    public void testAddImportBillException3() {
        //  not exist provider, not exist booktitle
        ImportBill importBill = new ImportBill();
        importBill.setSaleOff(0);
        importBill.setImportDate(LocalDate.now());
        importBill.setPaymentMethod("Tiền mặt");

        User user = new User();
        user.setId(1);

        Provider provider = new Provider();
        provider.setId(100);

        importBill.setUser(user);
        importBill.setProvider(provider);

        BookTitle bookTitle = new BookTitle();
        bookTitle.setId(100);
        ImportedBookTitle ibt = new ImportedBookTitle();
        ibt.setBookTitle(bookTitle);
        ibt.setQuantity(20);
        ibt.setUnitPrice(30000);

        BookTitle bookTitle1 = new BookTitle();
        bookTitle1.setId(200);
        ImportedBookTitle ibt1 = new ImportedBookTitle();
        ibt1.setBookTitle(bookTitle1);
        ibt1.setQuantity(20);
        ibt1.setUnitPrice(30000);

        ArrayList<ImportedBookTitle> ibts = new ArrayList<>();
        ibts.add(ibt);
        ibts.add(ibt1);

        importBill.setImportedBookTitleList(ibts);

        Connection connection = DAO.getConnection();
        try{
            connection.setAutoCommit(false);
            Assertions.assertFalse(importBillDAO.confirmImportBookTitle(importBill));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(!connection.getAutoCommit()) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }

    @Test
    public void testAddImportBillStandard() {
        ImportBill importBill = new ImportBill();
        importBill.setSaleOff(0);
        importBill.setImportDate(LocalDate.now());
        importBill.setPaymentMethod("Tiền mặt");

        User user = new User();
        user.setId(1);

        Provider provider = new Provider();
        provider.setId(1);

        importBill.setUser(user);
        importBill.setProvider(provider);

        BookTitle bookTitle = new BookTitle();
        bookTitle.setId(1);
        ImportedBookTitle ibt = new ImportedBookTitle();
        ibt.setBookTitle(bookTitle);
        ibt.setQuantity(20);
        ibt.setUnitPrice(30000);

        BookTitle bookTitle1 = new BookTitle();
        bookTitle1.setId(2);
        ImportedBookTitle ibt1 = new ImportedBookTitle();
        ibt1.setBookTitle(bookTitle1);
        ibt1.setQuantity(20);
        ibt1.setUnitPrice(30000);

        ArrayList<ImportedBookTitle> ibts = new ArrayList<>();
        ibts.add(ibt);
        ibts.add(ibt1);

        importBill.setImportedBookTitleList(ibts);

        Connection connection = DAO.getConnection();
        try{
            connection.setAutoCommit(false);
            Assertions.assertTrue(importBillDAO.confirmImportBookTitle(importBill));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(!connection.getAutoCommit()) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }
    @Test
    public void testAddImportBillException4() {
        // add 2 times consecutively 1 importbill, where exist provider, exist booktitle
        ImportBill importBill = new ImportBill();
        importBill.setSaleOff(0);
        importBill.setImportDate(LocalDate.now());
        importBill.setPaymentMethod("Tiền mặt");

        User user = new User();
        user.setId(1);

        Provider provider = new Provider();
        provider.setId(1);

        importBill.setUser(user);
        importBill.setProvider(provider);

        BookTitle bookTitle = new BookTitle();
        bookTitle.setId(1);
        ImportedBookTitle ibt = new ImportedBookTitle();
        ibt.setBookTitle(bookTitle);
        ibt.setQuantity(20);
        ibt.setUnitPrice(30000);

        BookTitle bookTitle1 = new BookTitle();
        bookTitle1.setId(2);
        ImportedBookTitle ibt1 = new ImportedBookTitle();
        ibt1.setBookTitle(bookTitle1);
        ibt1.setQuantity(20);
        ibt1.setUnitPrice(30000);

        ArrayList<ImportedBookTitle> ibts = new ArrayList<>();
        ibts.add(ibt);
        ibts.add(ibt1);

        importBill.setImportedBookTitleList(ibts);

        Connection connection = DAO.getConnection();
        try{
            connection.setAutoCommit(false);
            Assertions.assertTrue(importBillDAO.confirmImportBookTitle(importBill));
//            Assertions.assertFalse(importBillDAO.confirmImportBookTitle(importBill));
            Assertions.assertThrowsExactly(Exception.class, () -> {
                importBillDAO.confirmImportBookTitle(importBill);
            }, "Hóa đơn nhập đã tồn tại!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(!connection.getAutoCommit()) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
