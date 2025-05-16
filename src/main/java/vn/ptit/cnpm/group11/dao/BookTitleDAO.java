/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.ptit.cnpm.group11.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static vn.ptit.cnpm.group11.dao.DAO.connection;
import vn.ptit.cnpm.group11.model.BookTitle;

/**
 *
 * @author duongvct
 */
public class BookTitleDAO extends DAO{
    public ArrayList<BookTitle> searchBookTitleByName(String name) {
        ArrayList<BookTitle> bookTitles = new ArrayList<>();
        String sql = """
            SELECT *
            FROM tblBookTitle
            WHERE name LIKE ?
            """;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setNString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookTitle bookTitle = new BookTitle();
                bookTitle.setId(rs.getInt("id"));
                bookTitle.setName(rs.getNString("name"));
                bookTitle.setAuthor(rs.getNString("author"));
                bookTitle.setPublicationYear(rs.getInt("publication_year"));
                bookTitle.setPublisher(rs.getNString("publisher"));
                bookTitle.setUnitPrice(rs.getInt("unit_price"));
                bookTitles.add(bookTitle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookTitles;
    }
    public boolean addNewBookTitle(BookTitle bookTitle) throws Exception {
        ArrayList<BookTitle> bookTitles = this.searchBookTitleByName(bookTitle.getName());
        for (BookTitle bt : bookTitles) {
            if (bt.equals(bookTitle)) {
                throw new Exception("Đầu truyện đã tồn tại!");
            }
        }
        int isAdded = 0;
        String sql = 
        """
        INSERT INTO tblBookTitle (name, author, publication_year, publisher, unit_price)
        VALUES
        (?, ?, ?, ?, ?)
        """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setNString(1, bookTitle.getName());
            preparedStatement.setNString(2, bookTitle.getAuthor());
            preparedStatement.setInt(3, bookTitle.getPublicationYear());
            preparedStatement.setNString(4, bookTitle.getPublisher());
            preparedStatement.setInt(5, bookTitle.getUnitPrice());
            
            isAdded = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                bookTitle.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (isAdded == 1);
    }
}
