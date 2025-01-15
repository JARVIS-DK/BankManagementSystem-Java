package com.system.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.system.bank.dbconnection.DataBaseConnection;
import com.system.bank.entity.Accountant;

import com.system.bank.exception.AccountantException;


public class AccountantDaoImplementation implements AccountantDao{

    @Override
    public Accountant LoginAccountant(String accountantUserName, String accountantPassword) throws AccountantException {

        Accountant acc = null;

        try(Connection conn = DataBaseConnection.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from accountant where accountantUserName = ? and accountantPassword = ?");

            ps.setString(1, accountantUserName);
            ps.setString(2, accountantPassword);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                String n = rs.getString("accountantUserName");
                String e = rs.getString("accountantEmail");
                String p = rs.getString("accountantPassword");


                acc = new Accountant(n,e,p);

            }
        }
        catch(Exception e)
        {
            throw new AccountantException("Invalid UserName and Password!");
        }
        return acc;
    }



}
