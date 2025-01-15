package com.system.bank.entity;

public class Accountant {

    private String accountantUserName;
    private String accountEmail;
    private String accountantPassword;


    public Accountant() {
        super();
    }


    public Accountant(String accountantUserName, String accountEmail, String accountantPassword) {
        super();
        this.accountantUserName = accountantUserName;
        this.accountEmail = accountEmail;
        this.accountantPassword = accountantPassword;
    }


    public String getAccountantUserName() {
        return accountantUserName;
    }


    public void setAccountantUserName(String accountantUserName) {
        this.accountantUserName = accountantUserName;
    }


    public String getAccountEmail() {
        return accountEmail;
    }


    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }


    public String getAccountantPassword() {
        return accountantPassword;
    }


    public void setAccountantPassword(String accountantPassword) {
        this.accountantPassword = accountantPassword;
    }


    @Override
    public String toString() {
        return "Accountant [accountantUserName=" + accountantUserName + ", accountEmail=" + accountEmail
                + ", accountantPassword=" + accountantPassword + "]";
    }




}
