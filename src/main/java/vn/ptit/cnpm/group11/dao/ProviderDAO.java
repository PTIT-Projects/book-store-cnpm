/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vn.ptit.cnpm.group11.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
