/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cars;
import mylib.DBUtils;

/**
 * Data Access Object for Cars entity
 * Handles all database operations related to cars
 *
 * @author Huy
 */
public class CarsDAO {

    private static final Logger LOGGER = Logger.getLogger(CarsDAO.class.getName());

    // SQL Queries
    private static final String SELECT_ALL_CARS =
            "SELECT carID, serialNumber, model, colour, year, price FROM Cars WHERE isActive = 1";
    private static final String INSERT_CAR =
            "INSERT INTO Cars VALUES((SELECT ISNULL(MAX(CarID), 0) + 1 FROM Cars), ?, ?, ?, ?, ?, 1)";
    private static final String UPDATE_CAR_STATUS =
            "UPDATE Cars SET isActive = 0 WHERE carID = ?";
    private static final String UPDATE_CAR =
            "UPDATE Cars SET serialNumber = ?, model = ?, colour = ?, year = ?, price = ? WHERE carID = ?";
    private static final String SELECT_CAR_BY_FIELD =
            "SELECT carID, serialNumber, model, colour, year, price FROM Cars WHERE %s LIKE ? AND isActive = 1";
    private static final String SELECT_CAR_BY_ID =
            "SELECT carID, serialNumber, model, colour, year, price FROM Cars WHERE carID = ?";

    /**
     * Retrieves all active cars from the database
     * @return List of all cars
     */
    public List<Cars> getAllCars() {
        List<Cars> result = new ArrayList<>();

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_CARS);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                result.add(extractCarFromResultSet(rs));
            }

        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all cars", e);
        }

        return result;
    }

    /**
     * Inserts a new car into the database
     * @return true if insertion was successful
     */
    public boolean insertCar(String serialNumber, String model, String colour, String year, String price) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_CAR)) {

            stmt.setString(1, serialNumber);
            stmt.setString(2, model);
            stmt.setString(3, colour);
            stmt.setInt(4, Integer.parseInt(year));
            stmt.setInt(5, Integer.parseInt(price));

            int rowsAffected = stmt.executeUpdate();
            LOGGER.log(Level.INFO, "Car inserted successfully. Serial: {0}", serialNumber);
            return rowsAffected > 0;

        } catch (SQLException | ClassNotFoundException | NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Error inserting car", e);
            return false;
        }
    }

    /**
     * Soft deletes a car by setting isActive to 0
     * @param id the car ID to delete
     * @return true if deletion was successful
     */
    public boolean deleteCar(String id) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_CAR_STATUS)) {

            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();
            LOGGER.log(Level.INFO, "Car deleted successfully. ID: {0}", id);
            return rowsAffected > 0;

        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Error deleting car with ID: " + id, e);
            return false;
        }
    }

    /**
     * Updates an existing car's information
     * @return true if update was successful
     */
    public boolean updateCar(String carID, String serialNumber, String model, String colour, String year, String price) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_CAR)) {

            stmt.setString(1, serialNumber);
            stmt.setString(2, model);
            stmt.setString(3, colour);
            stmt.setString(4, year);
            stmt.setString(5, price);
            stmt.setString(6, carID);

            int rowsAffected = stmt.executeUpdate();
            LOGGER.log(Level.INFO, "Car updated successfully. ID: {0}", carID);
            return rowsAffected > 0;

        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Error updating car with ID: " + carID, e);
            return false;
        }
    }

    /**
     * Searches for cars by serial number
     * @param serialNumber the serial number to search for (partial match)
     * @return List of matching cars
     */
    public List<Cars> getCarsBySerialNumber(String serialNumber) {
        return searchCarsByField("serialNumber", serialNumber);
    }

    /**
     * Searches for cars by model
     * @param model the model to search for (partial match)
     * @return List of matching cars
     */
    public List<Cars> getCarsByModel(String model) {
        return searchCarsByField("model", model);
    }

    /**
     * Searches for cars by year
     * @param year the year to search for (partial match)
     * @return List of matching cars
     */
    public List<Cars> getCarsByYear(String year) {
        return searchCarsByField("year", year);
    }

    /**
     * Generic method to search cars by any field
     * @param fieldName the database column name to search
     * @param value the value to search for
     * @return List of matching cars
     */
    private List<Cars> searchCarsByField(String fieldName, String value) {
        List<Cars> result = new ArrayList<>();
        String query = String.format(SELECT_CAR_BY_FIELD, fieldName);

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + value + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result.add(extractCarFromResultSet(rs));
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Error searching cars by " + fieldName, e);
        }

        return result;
    }

    /**
     * Retrieves a specific car by its ID
     * @param carID the car ID
     * @return Car object or null if not found
     */
    public Cars getCarByID(String carID) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_CAR_BY_ID)) {

            stmt.setString(1, carID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractCarFromResultSet(rs);
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Error retrieving car with ID: " + carID, e);
        }

        return null;
    }

    /**
     * Helper method to extract Car object from ResultSet
     * Reduces code duplication
     * @param rs ResultSet containing car data
     * @return Cars object
     * @throws SQLException if database error occurs
     */
    private Cars extractCarFromResultSet(ResultSet rs) throws SQLException {
        return new Cars(
            rs.getString("carID"),
            rs.getString("serialNumber"),
            rs.getString("model"),
            rs.getString("colour"),
            rs.getString("year"),
            rs.getString("price")
        );
    }
}
