package vn.ptit.cnpm.group11.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vn.ptit.cnpm.group11.model.BookTitle;
import java.util.ArrayList;

public class BookTitleDAOTest {
    private final BookTitleDAO bookTitleDAO;

    public BookTitleDAOTest() {
        this.bookTitleDAO = new BookTitleDAO();
    }

    @Test
    public void testSearchBookTitleStandard() {
        String keyword = "7 viên ngọc rồng tập 6";
        ArrayList<BookTitle> results = bookTitleDAO.searchBookTitleByName(keyword);
        Assertions.assertNotNull(results);
        Assertions.assertEquals(4, results.size());
    }
    @Test
    public void testSearchBookTitleException() {
        String keyword = "xxx";
        ArrayList<BookTitle> results = bookTitleDAO.searchBookTitleByName(keyword);
        Assertions.assertNotNull(results);
        Assertions.assertEquals(0, results.size());
    }

    @Test
    public void testAddBookTitleStandard() throws Exception {
        BookTitle bookTitle = new BookTitle();
        bookTitle.setName("Test");
        bookTitle.setAuthor("Tác giả test");
        bookTitle.setPublisher("NXB test");
        bookTitle.setPublicationYear(2025);
        bookTitle.setUnitPrice(50000);
        boolean isAdded = bookTitleDAO.addNewBookTitle(bookTitle);
        Assertions.assertTrue(isAdded);
    }

    @Test
    public void testAddBookTitleException1() throws Exception {
        BookTitle bookTitle = new BookTitle();
        bookTitle.setName("7 viên ngọc rồng tập 6");
        bookTitle.setAuthor("Akira Toriyama");
        bookTitle.setPublisher("Kim Đồng");
        bookTitle.setPublicationYear(2023);
        bookTitle.setUnitPrice(30000);
        Assertions.assertThrowsExactly(Exception.class, () ->{
            bookTitleDAO.addNewBookTitle(bookTitle);
        }, "Đầu truyện đã tồn tại!");
    }
    @Test
    public void testAddBookTitleException2() throws Exception {
        BookTitle bookTitle = new BookTitle();
        bookTitle.setName("Test 2 lần liên tục");
        bookTitle.setAuthor("Tác giả test");
        bookTitle.setPublisher("NXB test");
        bookTitle.setPublicationYear(2025);
        bookTitle.setUnitPrice(50000);
        boolean isAdded = bookTitleDAO.addNewBookTitle(bookTitle);
        Assertions.assertTrue(isAdded);
        Assertions.assertThrowsExactly(Exception.class, () ->{
            bookTitleDAO.addNewBookTitle(bookTitle);
        }, "Đầu truyện đã tồn tại!");
    }
}
