package com.system.bank.entity;

public class Customer {
    private int customerAccountNumber;
    private String customerName;
    private int customerBalance;
    private String customerPassword;
    private String customerEmail;
    private String customerMobileNo;
    private String customerAddress;


    public Customer() {
        super();
    }



    public Customer(int customerAccountNumber, String customerName, int customerBalance, String customerPassword,
                    String customerEmail, String customerMobileNo, String customerAddress) {
        super();
        this.customerAccountNumber = customerAccountNumber;
        this.customerName = customerName;
        this.customerBalance = customerBalance;
        this.customerPassword = customerPassword;
        this.customerEmail = customerEmail;
        this.customerMobileNo = customerMobileNo;
        this.customerAddress = customerAddress;
    }



    public int getCustomerAccountNumber() {
        return customerAccountNumber;
    }



    public void setCustomerAccountNumber(int customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }



    public String getCustomerName() {
        return customerName;
    }



    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }



    public int getCustomerBalance() {
        return customerBalance;
    }



    public void setCustomerBalance(int customerBalance) {
        this.customerBalance = customerBalance;
    }



    public String getCustomerPassword() {
        return customerPassword;
    }



    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }



    public String getCustomerEmail() {
        return customerEmail;
    }



    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }



    public String getCustomerMobileNo() {
        return customerMobileNo;
    }



    public void setCustomerMobileNo(String customerMobileNo) {
        this.customerMobileNo = customerMobileNo;
    }



    public String getCustomerAddress() {
        return customerAddress;
    }



    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }



    @Override
    public String toString() {
        return "Customer [customerAccountNumber=" + customerAccountNumber + ", customerName=" + customerName
                + ", customerBalance=" + customerBalance + ", customerPassword=" + customerPassword + ", customerEmail="
                + customerEmail + ", customerMobileNo=" + customerMobileNo + ", customerAddress=" + customerAddress
                + "]";
    }





}
