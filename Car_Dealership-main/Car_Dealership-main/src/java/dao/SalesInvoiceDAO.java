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
import java.util.List;
import model.SalesInvoice;
import mylib.DBUtils;

/**
 *
 * @author Admin
 */
public class SalesInvoiceDAO {
    public SalesInvoice checkId(String id) {
        Connection cn = null;
        SalesInvoice s = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [invoiceID]\n"
                        + "      ,[invoiceDate]\n"
                        + "      ,[salesID]\n"
                        + "      ,[carID]\n"
                        + "      ,[custID]\n"
                        + "  FROM [dbo].[SalesInvoice]\n"
                        + "  WHERE [invoiceID] = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);
                ResultSet table = st.executeQuery();
                while (table.next()) {
                    String invoiceid = table.getString("invoiceID");
                    String invoicedate = table.getString("invoiceDate");
                    String salesid = table.getString("salesID");
                    String carid = table.getString("carID");
                    String custid = table.getString("custID");
                    s = new SalesInvoice(invoiceid, invoicedate, salesid, carid, custid);
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
        return s;
    }

    public int createInvoice(String invoiceID, String invoicedate, String salesID, String carID, String custID) {
        int rs = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[SalesInvoice]\n"
                        + "           ([invoiceID]\n"
                        + "           ,[invoiceDate]\n"
                        + "           ,[salesID]\n"
                        + "           ,[carID]\n"
                        + "           ,[custID])\n"
                        + "     VALUES (?,?,?,?,?)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, invoiceID);
                st.setString(2, invoicedate);
                st.setString(3, salesID);
                st.setString(4, carID);
                st.setString(5, custID);
                rs = st.executeUpdate();
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
        return rs;
    }
    
    public List<SalesInvoice> getInvoices(String custId) {
        List<SalesInvoice> invoices = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [invoiceID], [invoiceDate], [salesID], [carID], [custID] FROM [dbo].[SalesInvoice] WHERE [custID] = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, custId);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String invoiceid = rs.getString("invoiceID");
                    String invoicedate = rs.getString("invoiceDate");
                    String salesid = rs.getString("salesID");
                    String carid = rs.getString("carID");
                    String custid = rs.getString("custID");
                    invoices.add(new SalesInvoice(invoiceid, invoicedate, salesid, carid, custid));
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
        return invoices;
    }
    
    public List<SalesInvoice> getAllInvoices() {
        List<SalesInvoice> invoices = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [invoiceID], [invoiceDate], [salesID], [carID], [custID] FROM [dbo].[SalesInvoice]";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String invoiceid = rs.getString("invoiceID");
                    String invoicedate = rs.getString("invoiceDate");
                    String salesid = rs.getString("salesID");
                    String carid = rs.getString("carID");
                    String custid = rs.getString("custID");
                    invoices.add(new SalesInvoice(invoiceid, invoicedate, salesid, carid, custid));
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
        return invoices;
    }
    
    
}
