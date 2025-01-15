package com.system.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.system.bank.dbconnection.DataBaseConnection;
import com.system.bank.entity.Accountant;

import com.system.bank.entity.Customer;
import com.system.bank.exception.AccountantException;
import com.system.bank.exception.CustomerException;


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

    @Override
    public int addCustomer(String customerName, String customerMail, String customerPassword, String customerMobileNo,
                           String customerAddress) throws CustomerException {


        int cid = -1;
        try(Connection conn = DataBaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("insert into customerinformation (customerName,customerMail,customerPassword, customerMobileNo, customerAddress) values(?,?,?,?,?)");

            ps.setString(1, customerName);
            ps.setString(2, customerMail);
            ps.setString(3, customerPassword);
            ps.setString(4, customerMobileNo);
            ps.setString(5, customerAddress);

            int x = ps.executeUpdate();

            if(x>0) {
                PreparedStatement ps2 = conn.prepareStatement("select cid from customerinformation where customerMail = ? and customerMobileNo = ?");
                ps2.setString(1, customerMail);
                ps2.setString(2, customerMobileNo);

                ResultSet rs = ps2.executeQuery();

                if(rs.next())
                {
                    cid = rs.getInt("cid");
                }
                else
                {
                    System.out.println("Inserted Data is Incorrect Please Try Again!!");
                }

            }
//			else {
//				System.out.println("Can't Able To Add New Customer!!");
//			}
        }
        catch(SQLException e) {
            System.out.println("SQL Query Related Exception ");

        }
        return cid;
    }


    @Override
    public String addAccount(int customerBalance, int cid) throws CustomerException {

        String message = null;

        try(Connection conn = DataBaseConnection.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("insert into account(customerBalance,cid) values(?,?)");

            ps.setInt(1,customerBalance);
            ps.setInt(2,cid);

            int x = ps.executeUpdate();

            if(x>0)
            {
                System.out.println("Account Added Successfully!");
            }
            else {
                System.out.println("Insertion of Data Failed!!");
            }
        }
        catch(SQLException e) {
            System.out.println("SQL Related Exception");

        }
        return message;
    }

    @Override
    public String updateCustomer(int customerAccountNumber, String customerAddress) throws CustomerException {
        // TODO Auto-generated method stub

        String message = null;

        try(Connection conn = DataBaseConnection.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("update customerinformation i inner join account a on i.cid=a.cid and a.customerAccountNumber = ? set i.customerAddress = ?");

            ps.setInt(1, customerAccountNumber);
            ps.setString(2, customerAddress);

            int x = ps.executeUpdate();

            if(x>0) {
                System.out.println("Address Updated Successfully!");
            }
            else
            {
                System.out.println("Can't Able Update the Address");
                System.out.println("-----------------------------");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            message = e.getMessage();
        }


        return message;
    }


    @Override
    public String deleteAccount(int customerAccountNumber) throws CustomerException {
        // TODO Auto-generated method stub

        String message = null;

        try(Connection conn = DataBaseConnection.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("delete i from customerinformation i inner join account a on a.cid=i.cid where a.customerAccountNumber = ?");

            ps.setInt(1, customerAccountNumber);

            int x = ps.executeUpdate();

            if(x>0) {
                System.out.println("Account Deleted Successfully!!");
            }
            else{
                System.out.println("Account Deletion Failed --> Account Not Found!!");
                System.out.println("-----------------------------------------------");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public Customer viewCustomer(String customerAccountNumber) throws CustomerException {
        // TODO Auto-generated method stub

        Customer cu = null;

        try(Connection conn = DataBaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from customerinformation i inner join account a on a.cid = i.cid where customerAccountNumber = ?");

            ps.setString(1, customerAccountNumber);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                int accNum = rs.getInt("customerAccountNumber");

                String name = rs.getString("customerName");

                int bal = rs.getInt("customerBalance");

                String mail = rs.getString("customerMail");

                String pass = rs.getString("customerPassword");

                String mobile = rs.getString("customerMobileNo");

                String addr = rs.getString("customerAddress");


                cu = new Customer(accNum,name,bal,mail,pass,mobile,addr);
            }
            else {
                throw new CustomerException("Invalid Account Number!!");
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return cu;
    }
}
