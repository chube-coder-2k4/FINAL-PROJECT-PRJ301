/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class SalesInvoice {
    private String invoiceId;
    private String invoiceDate;
    private String salesId;
    private String carId;
    private String custId;

    public SalesInvoice() {
    }

    public SalesInvoice(String invoiceId, String invoiceDate, String salesId, String carId, String custId) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.salesId = salesId;
        this.carId = carId;
        this.custId = custId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
}
