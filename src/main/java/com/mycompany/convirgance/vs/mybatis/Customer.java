/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.convirgance.vs.mybatis;

/**
 *
 * @author timur
 */
public class Customer
{
    private int customerID;
    private String discountCode;
    private String zip;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String phone;
    private String fax;
    private String email;
    private int creditLimit;
    
    //Constructor
    public Customer(int customer_id, String discount_code, String zip, 
            String name, String addressline1, String addressline2,
            String city, String state, String phone, String fax, String email,
            int credit_limit)
    {
        this.customerID = customer_id;
        this.discountCode = discount_code;
        this.zip = zip;
        this.name = name;
        this.addressLine1 = addressline1;
        this.addressLine2 = addressline2;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.creditLimit = credit_limit;
    }
    
    // Getters and Setters

    public int getCustomerID() 
    {
        return customerID;
    }

    public void setCustomerID(int customer_id) 
    {
        this.customerID = customer_id;
    }

    public String getDiscountCode() 
    {
        return discountCode;
    }

    public void setDiscountCode(String discount_code) 
    {
        this.discountCode = discount_code;
    }

    public String getZip() 
    {
        return zip;
    }

    public void setZip(String zip) 
    {
        this.zip = zip;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getAddressLine1() 
    {
        return addressLine1;
    }

    public void setAddressLine1(String addressline1) 
    {
        this.addressLine1 = addressline1;
    }

    public String getAddressLine2() 
    {
        return addressLine2;
    }

    public void setAddressLine2(String addressline2) 
    {
        this.addressLine2 = addressline2;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getState() 
    {
        return state;
    }

    public void setState(String state) 
    {
        this.state = state;
    }

    public String getPhone() 
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getFax() 
    {
        return fax;
    }

    public void setFax(String fax) 
    {
        this.fax = fax;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public int getCreditLimit() 
    {
        return creditLimit;
    }

    public void setCreditLimit(int credit_limit) 
    {
        this.creditLimit = credit_limit;
    }
}
