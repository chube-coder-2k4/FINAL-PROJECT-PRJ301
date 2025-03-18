/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Huy
 */
public class SalesPerson {

    private String salesID;
    private String salesName;
    private String birthday;
    private String sex;
    private String salesAdderss;

    public SalesPerson(String salesID, String salesName, String birthday, String sex, String salesAdderss) {
        this.salesID = salesID;
        this.salesName = salesName;
        this.birthday = birthday;
        this.sex = sex;
        this.salesAdderss = salesAdderss;
    }

    public String getSalesID() {
        return salesID;
    }

    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSalesAdderss() {
        return salesAdderss;
    }

    public void setSalesAdderss(String salesAdderss) {
        this.salesAdderss = salesAdderss;
    }
}
