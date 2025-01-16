package com.system.bank.dao;

import com.system.bank.entity.Customer;
import com.system.bank.exception.CustomerException;

public interface CustomerDao {

    public Customer loginCustomer(String customerUserName,String customerPassword, int customerAccountNumber) throws CustomerException;

    public int viewBalance(int customerAccountNumber) throws CustomerException;

    public int deposit(int customerAccountNumber, int amount) throws CustomerException;

    public int withdraw(int customerAccountNumber, int amount) throws CustomerException;

    public int transfer(int customerAccountNumber1 ,int amount, int customerAccountNumber2) throws CustomerException;
}