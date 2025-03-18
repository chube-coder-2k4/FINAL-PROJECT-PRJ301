package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mylib.DBUtils;

public class ReportDAO {

    public List<Map<String, Object>> getCarsSoldByYear() {
        List<Map<String, Object>> result = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT YEAR(si.invoiceDate) AS year, COUNT(si.invoiceID) AS carsSold\n"
                        + "FROM SalesInvoice si\n"
                        + "GROUP BY YEAR(si.invoiceDate)\n"
                        + "ORDER BY year;");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("year", rs.getInt("year"));
                row.put("carsSold", rs.getInt("carsSold"));
                result.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Map<String, Object>> getRevenueByYear() {
        List<Map<String, Object>> result = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT c.year, SUM(c.price) as totalRevenue \n"
                        + "                        FROM Cars c\n"
                        + "                        GROUP BY c.year");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("year", rs.getInt("year"));
                row.put("totalRevenue", rs.getDouble("totalRevenue"));
                result.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Map<String, Object>> getBestSellingModels() {
        List<Map<String, Object>> result = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT c.model as model, COUNT(si.invoiceID) as salesCount \n"
                        + "                     FROM Cars c JOIN SalesInvoice si ON c.carID = si.carID \n"
                        + "                     GROUP BY c.model ORDER BY salesCount DESC ");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("model", rs.getString("model"));
                row.put("salesCount", rs.getInt("salesCount"));
                result.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Map<String, Object>> getBestUsedParts() {
        List<Map<String, Object>> result = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT p.partName as partName, SUM(pu.numberUsed) as totalUsed \n"
                        + "                        FROM Parts p JOIN PartsUsed pu ON p.partID = pu.partID \n"
                        + "                        GROUP BY p.partName ORDER BY totalUsed DESC");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("partName", rs.getString("partName"));
                row.put("totalUsed", rs.getInt("totalUsed"));
                result.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Map<String, Object>> getTopMechanics() {
        List<Map<String, Object>> result = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT TOP 3 m.mechanicName as mechanicName, COUNT(sm.serviceTicketID) as repairCount \n"
                        + "                        FROM Mechanic m JOIN ServiceMehanic sm ON m.mechanicID = sm.mechanicID \n"
                        + "                        GROUP BY m.mechanicName ORDER BY repairCount DESC");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("mechanicName", rs.getString("mechanicName"));
                row.put("repairCount", rs.getInt("repairCount"));
                result.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
