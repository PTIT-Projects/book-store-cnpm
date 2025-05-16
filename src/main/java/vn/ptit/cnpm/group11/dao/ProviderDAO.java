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
import vn.ptit.cnpm.group11.model.Provider;

/**
 *
 * @author duongvct
 */
public class ProviderDAO extends DAO{
    public ArrayList<Provider> searchProviderByName(String name) {
        ArrayList<Provider> providers = new ArrayList<>();
        String sql = """
            SELECT *
            FROM tblProvider
            WHERE name LIKE ?
            """;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setNString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Provider provider = new Provider();
                provider.setId(rs.getInt("id"));
                provider.setAddress(rs.getNString("address"));
                provider.setEmail(rs.getString("email"));
                provider.setPhoneNumber(rs.getString("phone_number"));
                provider.setNote(rs.getNString("note"));
                provider.setName(rs.getNString("name"));
                providers.add(provider);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return providers;
    }
    public boolean addNewProvider(Provider provider) throws Exception {

        String sqlCheck = """
                SELECT COUNT(*) FROM tblProvider
                WHERE name = ? AND address = ? AND email = ? AND phone_number = ?
                """;
        try {
            PreparedStatement ps = connection.prepareStatement(sqlCheck);
            ps.setNString(1, provider.getName());
            ps.setNString(2, provider.getAddress());
            ps.setString(3, provider.getEmail());
            ps.setString(4, provider.getPhoneNumber());
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                throw new Exception("Nhà cung cấp đã tồn tại!");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        int isAdded = 0;
        String sql = 
        """
        INSERT INTO tblProvider (name, address, email, phone_number, note)
        VALUES
        (?, ?, ?, ?, ?)
        """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setNString(1, provider.getName());
            preparedStatement.setNString(2, provider.getAddress());
            preparedStatement.setString(3, provider.getEmail());
            preparedStatement.setString(4, provider.getPhoneNumber());
            preparedStatement.setNString(5, provider.getNote());
            
            isAdded = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                provider.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (isAdded == 1);
    }
}
