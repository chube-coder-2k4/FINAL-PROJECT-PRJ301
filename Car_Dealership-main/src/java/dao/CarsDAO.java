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
import model.Cars;
import mylib.DBUtils;

/**
 *
 * @author Huy
 */
public class CarsDAO {

    public ArrayList<Cars> getAllCars() {
        ArrayList<Cars> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String query = "SELECT carID, serialNumber, model, colour, year, price "
                        + "FROM Cars ";
                PreparedStatement st = cn.prepareStatement(query);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String carID = table.getString("carID");
                        String serialNumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        String colour = table.getString("colour");
                        String year = table.getString("year");
                        String price = table.getString("price");
                        Cars car = new Cars(carID, serialNumber, model, colour, year,price);
                        result.add(car);
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

    public boolean insertCar(String serialNumber, String model, String colour, String year, String price) {
        int line = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String query = "INSERT INTO Cars "
                        + "VALUES((select top 1 CarID from Cars order by CarID desc)+1, ?, ?, ?, ?, ?, 1)";
                PreparedStatement st = cn.prepareStatement(query);
                st.setString(1, serialNumber);
                st.setString(2, model);
                st.setString(3, colour);
                st.setInt(4, Integer.parseInt(year));
                st.setInt(5, Integer.parseInt(price));
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

    public boolean deleteCar(String id) {
        int line = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String query = "UPDATE Cars "
                        + "set isActive = 0 "
                        + "where carID = ?";
                PreparedStatement st = cn.prepareStatement(query);
                st.setString(1, id);
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

    public boolean updateCar(String carID, String serialNumber, String model, String colour, String year, String price) {
        int line = 0;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE Cars "
                        + "SET serialNumber = ?, model = ?, colour = ?, year = ?, price = ? "
                        + "WHERE carID = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, serialNumber);
                st.setString(2, model);
                st.setString(3, colour);
                st.setString(4, year);
                st.setString(5, price);
                st.setString(6, carID);
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

    public ArrayList<Cars> getCarsBySerialNumber(String serialNumber) {
        ArrayList<Cars> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String query = "SELECT carID, serialNumber, model, colour, year, price "
                        + "FROM Cars "
                        + "WHERE serialNumber like ? and isActive = 1";
                PreparedStatement st = cn.prepareStatement(query);
                st.setString(1, "%" + serialNumber + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String carID = table.getString("carID");
                        String serialNNumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        String colour = table.getString("colour");
                        String year = table.getString("year");
                        String price = table.getString("price");
                        Cars car = new Cars(carID, serialNNumber, model, colour, year, price);
                        result.add(car);
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

    public ArrayList<Cars> getCarsByModel(String model) {
        ArrayList<Cars> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String query = "SELECT carID, serialNumber, model, colour, year, price "
                        + "FROM Cars "
                        + "WHERE model like ? and isActive = 1";
                PreparedStatement st = cn.prepareStatement(query);
                st.setString(1, "%" + model + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String carID = table.getString("carID");
                        String serialNumber = table.getString("serialNumber");
                        String modell = table.getString("model");
                        String colour = table.getString("colour");
                        String year = table.getString("year");
                        String price = table.getString("price");
                        Cars car = new Cars(carID, serialNumber, modell, colour, year, price);
                        result.add(car);
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

    public ArrayList<Cars> getCarsByYear(String year) {
        ArrayList<Cars> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String query = "SELECT carID, serialNumber, model, colour, year, price "
                        + "FROM Cars "
                        + "WHERE year like ? and isActive = 1";
                PreparedStatement st = cn.prepareStatement(query);
                st.setString(1, "%" + year + "%");
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String carID = table.getString("carID");
                        String serialNumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        String colour = table.getString("colour");
                        String yearr = table.getString("year");
                        String price = table.getString("price");
                        Cars car = new Cars(carID, serialNumber, model, colour, yearr, price);
                        result.add(car);
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

    public Cars getCarByID(String carID) {
        Cars rs = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String query = "SELECT carID, serialNumber, model, colour, year, price "
                        + "FROM Cars "
                        + "WHERE carID = ?";
                PreparedStatement st = cn.prepareStatement(query);
                st.setString(1, carID);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String serialNumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        String colour = table.getString("colour");
                        String year = table.getString("year");
                        String price = table.getString("price");
                        Cars car = new Cars(carID, serialNumber, model, colour, year, price);
                        rs = car;
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

    public ArrayList<Cars> getCarsByCustID(String custID) {
        ArrayList<Cars> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String query = "SELECT b.carID, b.serialNumber, b.model, b.colour, b.year, b.price "
                        + "FROM SalesInvoice a "
                        + "JOIN Cars b on a.carID = b.carID "
                        + "where a.custID = ?";
                PreparedStatement st = cn.prepareStatement(query);
                st.setString(1, custID);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String carID = table.getString("carID");
                        String serialNumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        String colour = table.getString("colour");
                        String yearr = table.getString("year");
                        String price = table.getString("price");
                        Cars car = new Cars(carID, serialNumber, model, colour, yearr, price);
                        result.add(car);
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

    public ArrayList<Cars> defaultListCars() {
        ArrayList<Cars> result = new ArrayList<>();
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String query = "select top 10 carID, serialNumber, model, colour, year, price\n"
                        + "from Cars "
                        + "where isActive = 1";
                PreparedStatement st = cn.prepareStatement(query);
                ResultSet table = st.executeQuery();
                if (table != null) {
                    while (table.next()) {
                        String carID = table.getString("carID");
                        String serialNumber = table.getString("serialNumber");
                        String model = table.getString("model");
                        String colour = table.getString("colour");
                        String year = table.getString("year");
                        String price = table.getString("price");
                        Cars car = new Cars(carID, serialNumber, model, colour, year, price);
                        result.add(car);
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
