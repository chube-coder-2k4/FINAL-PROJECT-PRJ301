/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Parts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author Admin
 */
public class PartsDAO {

    public ArrayList<Parts> getParts() {
        Connection cn = null;
        ArrayList<Parts> ds = new ArrayList<>();
       
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [partID]\n"
                        + "      ,[partName]\n"
                        + "      ,[purchasePrice]\n"
                        + "      ,[retailPrice]\n"
                        + "  FROM [dbo].[Parts]";
                PreparedStatement st = cn.prepareStatement(sql);
                ResultSet table = st.executeQuery();
                while(table.next()){
                    String id = table.getString("partID");
                    String name = table.getString("partName");
                    double purchase = table.getDouble("purchasePrice");
                    double retail = table.getDouble("retailPrice");
                    Parts d = new Parts(id, name, purchase, retail);
                    ds.add(d);
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
        
        return ds;
    }
    
    
    public ArrayList<Parts> getPartByName(String part) {
        Connection cn = null;
        ArrayList<Parts> ds = new ArrayList<>();
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [partID]\n"
                        + "      ,[partName]\n"
                        + "      ,[purchasePrice]\n"
                        + "      ,[retailPrice]\n"
                        + "  FROM [dbo].[Parts] Where [partName] like ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, "%" + part + "%");
                ResultSet table = st.executeQuery();
                while(table.next()){
                    String id = table.getString("partID");
                    double purchase = table.getDouble("purchasePrice");
                    String name = table.getString("partName");
                    double retail = table.getDouble("retailPrice");
                    Parts d = new Parts(id, name, purchase, retail);
                    ds.add(d);
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
        
        return ds;
    }
    public Parts findPartsById(String partId) {
        Parts pt = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT [partID], [partName], [purchasePrice], [retailPrice] FROM [dbo].[Parts] WHERE [partID] = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, partId);
                ResultSet table = st.executeQuery();
                if (table.next()) {
                    String id = table.getString("partID");
                    String partname = table.getString("partName");
                    double price = table.getDouble("purchasePrice");
                    double retail = table.getDouble("retailPrice");
                    pt = new Parts(id, partname, price, retail);
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
        return pt;
    }
    
    
    public int updateParts(String partId, String partName, double purchasePrice, double retailPrice) {
        int result = 0;
        Connection cn = null;

        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE [dbo].[Parts] "
                        + "SET [partName] = ?, "
                        + "    [purchasePrice] = ?, "
                        + "    [retailPrice] = ? "
                        + "WHERE [partID] = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, partName);
                st.setDouble(2, purchasePrice);
                st.setDouble(3, retailPrice);
                st.setString(4, partId);

                result = st.executeUpdate();
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
    
    
    public int insertParts(String partName, double purchasePrice, double retailPrice) {
        int result = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO [dbo].[Parts]\n"
                        + "           ([partID]\n"
                        + "           ,[partName]\n"
                        + "           ,[purchasePrice]\n"
                        + "           ,[retailPrice])\n"
                        + "     VALUES ((select top 1 partID from Parts order by partID desc)+1,?,?,?)";
                PreparedStatement st = cn.prepareStatement(sql);
                
                st.setString(1, partName);
                st.setDouble(2, purchasePrice);
                st.setDouble(3, retailPrice);
                result = st.executeUpdate();

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
    
    
    public boolean deleteById(String id) {
        boolean result = false;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "DELETE FROM [dbo].[Parts] WHERE [partID] = ?\n";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, id);
                st.executeUpdate();
                result = true;
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
