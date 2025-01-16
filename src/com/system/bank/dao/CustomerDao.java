package com.system.bank.dao;

import com.system.bank.entity.Customer;
import com.system.bank.exception.CustomerException;

public interface CustomerDao {

    public Customer loginCustomer(String customerUserName,String customerPassword, int customerAccountNumber) throws CustomerException;

    public int viewBalance(int customerAccountNumber) throws CustomerException;
}