package com.system.bank.dao;

import com.system.bank.entity.Accountant;
import com.system.bank.entity.Customer;
import com.system.bank.exception.AccountantException;
import com.system.bank.exception.CustomerException;

public interface AccountantDao {

    public Accountant LoginAccountant(String accountantUsername, String accountantPassword) throws AccountantException;


    public int addCustomer(String customerName, String customerMail, String customerPassword, String customerMobileNo,
                    String customerAddress) throws CustomerException;

    public String addAccount(int customerBalance, int cid) throws CustomerException;
}
