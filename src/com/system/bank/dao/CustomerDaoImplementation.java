package com.system.bank.dao;

import com.system.bank.dbconnection.DataBaseConnection;
import com.system.bank.entity.Customer;
import com.system.bank.exception.CustomerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImplementation implements CustomerDao {
    @Override
    public Customer loginCustomer(String customerUserName, String customerPassword, int customerAccountNumber)
            throws CustomerException {


        Customer customer = null;

        try(Connection conn = DataBaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from customerinformation i inner join account a on a.cid = i.cid where customerName = ? and customerPassword = ? and customerAccountNumber = ?");

            ps.setString(1, customerUserName);
            ps.setString(2, customerPassword);
            ps.setInt(3, customerAccountNumber);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                int ac = rs.getInt("customerAccountNumber");
                String n = rs.getString("customerName");
                int b = rs.getInt("customerBalance");
                String e = rs.getString("customerMail");
                String p = rs.getString("customerPassword");
                String m = rs.getString("customerMobileNo");
                String a = rs.getString("customerAddress");

                customer = new Customer(ac,n,b,e,p,m,a);

            }
            else {
                throw new CustomerException("Invalid Customer Name or Password!! ----- Please Try Again!!");
            }

        }
        catch(SQLException e) {
            throw new CustomerException(e.getMessage());
        }

        return customer;
    }
}
