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

    @Override
    public int viewBalance(int customerAccountNumber) throws CustomerException {

        int bal = -1;

        try(Connection conn = DataBaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select customerBalance from account where customerAccountNumber = ?");

            ps.setInt(1, customerAccountNumber);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                bal = rs.getInt("customerBalance");
            }
        }
        catch(SQLException e) {
            throw new CustomerException(e.getMessage());
        }


        return bal;
    }

    @Override
    public int deposit(int customerAccountNumber, int amount) throws CustomerException {

        int bal = -1;

        try(Connection conn = DataBaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("update account set customerBalance = customerBalance + ? where customerAccountNumber = ?");

            ps.setInt(1, amount);
            ps.setInt(2, customerAccountNumber);

            int rs = ps.executeUpdate();
        }
        catch(SQLException e) {
            throw new CustomerException(e.getMessage());
        }

        return bal;
    }

    @Override
    public int withdraw(int customerAccountNumber, int amount) throws CustomerException {

        int vb = viewBalance(customerAccountNumber);

        if(vb > amount) {
            try(Connection conn = DataBaseConnection.provideConnection()) {
                PreparedStatement ps = conn.prepareStatement("update account set customerBalance = customerBalance - ? where customerAccountNumber = ?");

                ps.setInt(1, amount);
                ps.setInt(2, customerAccountNumber);

                int rs = ps.executeUpdate();
            }
            catch(SQLException e) {
                throw new CustomerException(e.getMessage());
            }
        }
        else {
            throw new CustomerException("Insufficient Balance..!!");
        }

        return vb + amount;
    }

    @Override
    public int transfer(int customerAccountNumber1, int amount, int customerAccountNumber2) throws CustomerException {


        int vb = viewBalance(customerAccountNumber1);

        if(vb > amount && checkAccount(customerAccountNumber2)) {
            int wit = withdraw(customerAccountNumber1,amount);
            int dep = deposit(customerAccountNumber2,amount);
        }
        else {
            throw new CustomerException("Insuffient Balance..!!");
        }
        return 0;
    }
    private boolean checkAccount(int customerAccountNumber) {


        try(Connection conn = DataBaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from account where customerAccountNumber = ? ");

            ps.setInt(1, customerAccountNumber);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return true;
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
