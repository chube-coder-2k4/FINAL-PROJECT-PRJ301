/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SalesPerson;
import model.ServiceTicket;
import mylib.DBUtils;

/**
 *
 * @author Huy
 */
public class ServiceTicketDAO {
    public ArrayList<ServiceTicket> getAllTicket(String custID){
        ArrayList<ServiceTicket> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if(cn != null){
                String query = "SELECT serviceTicketID, dateReceived, dateReturned, custID, carID "
                        + "FROM ServiceTicket "
                        + "WHERE custID = ?";
                PreparedStatement st = cn.prepareStatement(query);
                st.setString(1, custID);
                ResultSet table = st.executeQuery();
                if(table != null){
                    while(table.next()){
                        String ticketID = table.getString("serviceTicketID");
                        String dateReceived = table.getString("dateReceived");
                        String dateReturned = table.getString("dateReturned");
                        String carID = table.getString("carID");
                        ServiceTicket ticket = new ServiceTicket(ticketID, dateReceived, dateReturned, custID, carID);
                        list.add(ticket);
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
        return list;
    }
    
    public boolean insertTicket(String dateReceived, String dateReturned, String custID, String carID){
        int line = 0;
        Connection cn = null;
        try{
            cn = DBUtils.getConnection();
            if(cn != null){
                String query = "INSERT INTO ServiceTicket "
                        + "VALUES((select top 1 serviceTicketID from ServiceTicket order by serviceTicketID desc)+1, ?, ?, ?, ?)";
                PreparedStatement st = cn.prepareStatement(query);
                st.setString(1, dateReceived);
                st.setString(2, dateReturned);
                st.setString(3, custID);
                st.setString(4, carID);
                line = st.executeUpdate();
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
             try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (line > 0);
    }
}
