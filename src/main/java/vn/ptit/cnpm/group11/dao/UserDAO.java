/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.ptit.cnpm.group11.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import vn.ptit.cnpm.group11.model.User;

/**
 *
 * @author duongvct
 */
public class UserDAO extends DAO {
    public boolean checkLogin(User user) {
        boolean result = false;
        String sql = """
        SELECT * 
        FROM tblUser
        WHERE username = ?
                     """;
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()) {
                return result;
            }
            String hashedPass = rs.getString("password");
            if (!encoder.matches(user.getPassword(), hashedPass)) {
                return result;
            }
            user.setFullName(rs.getString("full_name"));
            user.setRole(rs.getString("role"));
            user.setId(rs.getInt("id"));
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public void changePass() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String sql = """
        UPDATE tblUser
        SET password=?
        WHERE username = 'a'
        """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, encoder.encode("123456"));
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
