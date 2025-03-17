/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author Huy
 */
public class CustomerDAO {

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT custID, custName, phone, sex, cusAddress "
                        + "FROM Customer";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String custID = table.getString("custID");
                        String custName = table.getString("custName");
                        String phone = table.getString("phone");
                        String sex = table.getString("sex");
                        String cusAddress = table.getString("cusAddress");
                        Customer cus = new Customer(custID, custName, phone, sex, cusAddress);
                        result.add(cus);
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

    public boolean insertCustomer(String custName, String phone, String sex, String cusAddress) {
        int line = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO Customer "
                        + "VALUES((select top 1 custID\n"
                        + "from Customer\n"
                        + "order by custID desc)+1, ?, ?, ?, ?, 1)";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, custName);
                st.setString(2, phone);
                st.setString(3, sex);
                st.setString(4, cusAddress);
                line = st.executeUpdate();
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
        return (line > 0);
    }

    public boolean updateCustomer(String custID, String custName, String phone, String sex, String cusAddress) {
        int line = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Customer "
                        + "SET custName = ?, phone = ?, sex = ?, cusAddress = ? "
                        + "WHERE custID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, custName);
                st.setString(2, phone);
                st.setString(3, sex);
                st.setString(4, cusAddress);
                st.setString(5, custID);
                line = st.executeUpdate();
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
        return (line > 0);
    }

    public boolean deleteCustomer(String custID) {
        PreparedStatement st = null;
        int rowsAffected = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Customer "
                        + "SET isActive = 0"
                        + "WHERE custID = ?";
                st = cn.prepareStatement(sql);
                st.setString(1, custID);
                rowsAffected = st.executeUpdate();
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
        return (rowsAffected > 0);
    }

    public ArrayList<Customer> searchCustomerByName(String cusName) {
        ArrayList<Customer> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT custID, custName, phone, sex, cusAddress "
                        + "FROM Customer "
                        + "WHERE custName like ? and isActive = 1";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + cusName + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String custID = table.getString("custID");
                        String custName = table.getString("custName");
                        String phone = table.getString("phone");
                        String sex = table.getString("sex");
                        String cusAddress = table.getString("cusAddress");
                        Customer cus = new Customer(custID, custName, phone, sex, cusAddress);
                        result.add(cus);
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

    public Customer getCustomerById(String custID) {
        Customer rs = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT custID, custName, phone, sex, cusAddress "
                        + "FROM Customer "
                        + "WHERE custID = ? and isActive = 1";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, custID);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String custName = table.getString("custName");
                        String phone = table.getString("phone");
                        String sex = table.getString("sex");
                        String cusAddress = table.getString("cusAddress");
                        Customer cus = new Customer(custID, custName, phone, sex, cusAddress);
                        rs = cus;
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
        return rs;
    }

    public ArrayList<Customer> defaultCustomerList() {
        ArrayList<Customer> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT TOP 10 custID, custName, phone, sex, cusAddress "
                        + "FROM Customer "
                        + "WHERE isActive = 1";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String custID = table.getString("custID");
                        String custName = table.getString("custName");
                        String phone = table.getString("phone");
                        String sex = table.getString("sex");
                        String cusAddress = table.getString("cusAddress");
                        Customer cus = new Customer(custID, custName, phone, sex, cusAddress);
                        result.add(cus);
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
