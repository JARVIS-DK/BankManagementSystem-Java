package com.system.bank.dao;

import com.system.bank.entity.Accountant;
import com.system.bank.entity.Customer;
import com.system.bank.exception.AccountantException;
import com.system.bank.exception.CustomerException;

public interface AccountantDao {

    public Accountant LoginAccountant(String acconttantUsername, String accountantPassword) throws AccountantException;



}
