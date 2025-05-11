/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.ptit.cnpm.group11.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import vn.ptit.cnpm.group11.model.User;

/**
 *
 * @author duongvct
 */
public class UserDAOTest {
    private UserDAO userDAO;

    public UserDAOTest() {
        userDAO = new UserDAO();
    }

//    @Test
//    public void testCheckLoginException() {
//        String username = "b";
//        String password = "12345678";
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        boolean result = userDAO.checkLogin(user);
//        Assertions.assertFalse(result);
//        Assertions.assertEquals(0, user.getId());
//        Assertions.assertNull(user.getFullName());
//        Assertions.assertNull(user.getRole());
//    }
//    @Test
//    public void testCheckLoginStandard() {
//        String username = "a";
//        String password = "123456";
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        boolean result = userDAO.checkLogin(user);
//        Assertions.assertTrue(result);
//        Assertions.assertNotEquals(0, user.getId());
//        Assertions.assertNotNull(user.getFullName());
//        Assertions.assertNotNull(user.getRole());
//    }
    
}
