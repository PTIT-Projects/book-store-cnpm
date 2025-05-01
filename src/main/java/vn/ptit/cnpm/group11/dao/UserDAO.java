/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.ptit.cnpm.group11.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            AND password = ?
                     """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setFullName(rs.getString("full_name"));
                user.setRole(rs.getString("role"));
                user.setId(rs.getInt("id"));
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    
}
