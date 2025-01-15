package com.system.bank.dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public static Connection provideConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3308/bankingsystem";

        try {
            conn = DriverManager.getConnection(url, "root", "1234");
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Exception occur in DataBase");
        }

        return conn;

    }
}
