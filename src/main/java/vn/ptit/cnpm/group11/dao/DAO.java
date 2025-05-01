/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.ptit.cnpm.group11.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author duongvct
 */
public class DAO {
    protected static Connection connection;
    public DAO(){
        if (connection == null) {
            Properties properties = new Properties();
            try (InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties")) {
                if (input == null) {
                    System.out.println("Cannot find application.properties file");
                    return;
                }
                properties.load(input);
                String dbURL = properties.getProperty("url");
                String dbUsername = properties.getProperty("user");
                String dbPassword = properties.getProperty("password");
                try {
                    connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
                    System.out.println("Connect to database successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
            
        }
    }

    public static Connection getConnection() {
        return connection;
    }
    
    
}
