/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Car entity representing a car in the dealership
 *
 * @author Huy
 */
public class Cars {
    private int carID;
    private String serialNumber;
    private String model;
    private String colour;
    private int year;
    private BigDecimal price;

    public Cars(String carID, String serialNumber, String model, String colour, String year, String price) {
        this.carID = Integer.parseInt(carID);
        this.serialNumber = serialNumber;
        this.model = model;
        this.colour = colour;
        this.year = Integer.parseInt(year);
        this.price = new BigDecimal(price);
    }

    public Cars(int carID, String serialNumber, String model, String colour, int year, BigDecimal price) {
        this.carID = carID;
        this.serialNumber = serialNumber;
        this.model = model;
        this.colour = colour;
        this.year = year;
        this.price = price;
    }

    // Getters
    public int getCarID() {
        return carID;
    }

    public String getCarIDAsString() {
        return String.valueOf(carID);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getYear() {
        return year;
    }

    public String getYearAsString() {
        return String.valueOf(year);
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getPriceAsString() {
        return price.toString();
    }

    // Setters
    public void setCarID(String carID) {
        this.carID = Integer.parseInt(carID);
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setYear(String year) {
        this.year = Integer.parseInt(year);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return carID == cars.carID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carID);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "carID=" + carID +
                ", serialNumber='" + serialNumber + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
