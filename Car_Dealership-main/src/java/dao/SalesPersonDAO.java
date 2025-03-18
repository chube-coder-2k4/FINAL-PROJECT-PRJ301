/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.SalesPerson;
import mylib.DBUtils;

/**
 *
 * @author Huy
 */
public class SalesPersonDAO {

    public SalesPerson checkLogin(String name) {
        SalesPerson result = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if(cn != null){
                String query = "SELECT salesID, salesName, birthday, sex, salesAddress "
                        + "FROM SalesPerson "
                        + "WHERE salesName = ?";
                PreparedStatement st = cn.prepareStatement(query);
                st.setString(1, name);
                ResultSet table = st.executeQuery();
                if(table != null){
                    while(table.next()){
                        String salesID = table.getString("salesID");
                        String birthday = table.getString("birthday");
                        String sex = table.getString("sex");
                        String salesAddress = table.getString("salesAddress");
                        SalesPerson s = new SalesPerson(salesID, name, birthday, sex, salesAddress);
                        result = s;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
