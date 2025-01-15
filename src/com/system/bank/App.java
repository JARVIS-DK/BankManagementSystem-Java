package com.system.bank;

import com.system.bank.dao.AccountantDao;
import com.system.bank.dao.AccountantDaoImplementation;
import com.system.bank.entity.Accountant;
import com.system.bank.exception.AccountantException;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws AccountantException {
        Scanner sc = new Scanner(System.in);

        boolean f = true;

        while (f) {

            System.out.println("-----------WELCOME TO ONLINE BANKING SYSTEM-----------");
            System.out.println("------------------------------------------------------");
            System.out.println("1. ADMIN LOGIN PORTAL \r\n" + "2. Customer");

            System.out.println("Choose your Option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Admin Login Credentials ------------------ Accountant");
                    System.out.println("Enter UserName : ");
                    String username = sc.nextLine();
                    System.out.println("Enter Password : ");
                    String password = sc.nextLine();


                    AccountantDao ad = new AccountantDaoImplementation();

                    try {
                        Accountant a = ad.LoginAccountant(username, password);
                        if (a == null) {
                            System.out.println("Wrong Credentials!");
                            break;
                        }
                        System.out.println("Login Successfully!!");

                        System.out.println("Welcome to : " + a.getAccountantUserName() + "as Admin of Online Banking System");


                    } catch(AccountantException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
