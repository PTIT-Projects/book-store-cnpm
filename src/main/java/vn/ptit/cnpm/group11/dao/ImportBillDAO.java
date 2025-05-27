/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.ptit.cnpm.group11.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import vn.ptit.cnpm.group11.model.ImportBill;
import vn.ptit.cnpm.group11.model.ImportedBookTitle;

/**
 *
 * @author duongvct
 */
public class ImportBillDAO extends DAO{
    public boolean confirmImportBookTitle(ImportBill importBill) throws Exception {
        String sqlCheck = """
            SELECT COUNT(*) FROM tblImportBill
            WHERE import_date = ? AND provider_id = ? AND user_id = ? AND payment_method = ?
        """;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        PreparedStatement ps = connection.prepareStatement(sqlCheck);
        ps.setString(1, importBill.getImportDate().format(formatter));
        ps.setInt(2, importBill.getProvider().getId());
        ps.setInt(3, importBill.getUser().getId());
        ps.setNString(4, importBill.getPaymentMethod());
        ResultSet rs = ps.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            throw new Exception("Hóa đơn nhập đã tồn tại!");
        }

        String sqlAddImportBill =
        """
        INSERT INTO tblImportBill
        (import_date, sale_off, payment_method, note, user_id, provider_id)
        VALUES (?, ?, ?, ?, ?, ?);
        """;

        String sqlAddImportedBookTitle =
        """
        INSERT INTO tblImportedBookTitle
        (quantity, unit_price, import_bill_id, book_title_id)
        VALUES (?, ?, ?, ?);
        """;
        boolean isSuccess = true;
        try {
            connection.setAutoCommit(false);
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            ps = connection.prepareStatement(sqlAddImportBill, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, importBill.getImportDate().format(formatter));
            ps.setInt(2, importBill.getSaleOff());
            ps.setNString(3, importBill.getPaymentMethod());
            ps.setNString(4, importBill.getNote());
            ps.setInt(5, importBill.getUser().getId());
            ps.setInt(6, importBill.getProvider().getId());
            
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                importBill.setId(generatedKeys.getInt(1));
                
                for (ImportedBookTitle ibt : importBill.getImportedBookTitleList()) {
                    ps = connection.prepareStatement(sqlAddImportedBookTitle, Statement.RETURN_GENERATED_KEYS);
                    ps.setInt(1, ibt.getQuantity());
                    ps.setInt(2, ibt.getUnitPrice());
                    ps.setInt(3, importBill.getId());
                    ps.setInt(4, ibt.getBookTitle().getId());
                    ps.executeUpdate();
                    
                    generatedKeys = ps.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        ibt.setId(generatedKeys.getInt(1));
                    }
                }
            }
            connection.commit();
        } catch (SQLException e) {
            isSuccess = false;
            try {
                connection.rollback();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                isSuccess = false;
                ex.printStackTrace();
            }
        }
        return isSuccess;
    }
    
    
    
}
