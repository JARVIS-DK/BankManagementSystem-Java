package com.system.bank;

import com.system.bank.dao.AccountantDao;
import com.system.bank.dao.AccountantDaoImplementation;
import com.system.bank.dao.CustomerDao;
import com.system.bank.dao.CustomerDaoImplementation;
import com.system.bank.entity.Accountant;
import com.system.bank.entity.Customer;
import com.system.bank.exception.AccountantException;
import com.system.bank.exception.CustomerException;

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

                        System.out.println("Welcome : " + a.getAccountantUserName() + " as Admin of Online Banking System");

                        boolean y = true;

                        while(y) {
                            System.out.println("-----------------------------\r\n"
                                    + "1. Add New Customer Account \r\n"
                                    + "2. Update Customer Address \r\n"
                                    + "3. Delete the Account by Account Number \r\n"
                                    + "4. View Particular Account Details by Account Number \r\n"
                                    + "5. View All Account Details \r\n"
                                    + "6. Account Logout \r\n"
                            );

                            int x = Integer.parseInt(sc.nextLine());

                            if (x == 1) {
                                System.out.println("---------New Account---------");
                                System.out.println("Enter Customer Name: ");
                                String a1 = sc.nextLine();
                                System.out.println("Enter Account Opening Balance : ");
                                int a2 = Integer.parseInt(sc.nextLine());
                                System.out.println("Enter Customer Email: ");
                                String a3 = sc.nextLine();
                                System.out.println("Enter Customer Password: ");
                                String a4 = sc.nextLine();
                                System.out.println("Enter Customer Mobile Number: ");
                                String a5 = sc.nextLine();
                                System.out.println("Enter Customer Address: ");
                                String a6 = sc.nextLine();

                                int s1 = -1;
                                try {
                                    s1 = ad.addCustomer(a1, a3, a4, a5, a6);
                                    try {
                                        ad.addAccount(a2, s1);
                                    } catch (CustomerException e) {
                                        e.printStackTrace();
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                System.out.println("------------------------------------");
                            }
                            if(x==2) {
                                System.out.println("Update Customer Address");
                                System.out.println("Enter Customer Account Number: ");
                                int u = Integer.parseInt(sc.nextLine());
                                System.out.println("Enter New Address: ");
                                String u2 = sc.nextLine();

                                try {
                                    String mes = ad.updateCustomer(u, u2);
                                }
                                catch(CustomerException e) {
                                    e.printStackTrace();
                                }
                            }
                            if(x==3) {
                                System.out.println("------Remove Account------");
                                System.out.println("Enter Account Number: ");
                                int ac = Integer.parseInt(sc.nextLine());
                                String s = null;

                                try {
                                    s = ad.deleteAccount(ac);
                                }
                                catch(CustomerException e) {
                                    e.printStackTrace();
                                }


                                if(s!=null)
                                {
                                    System.out.println(s);
                                }


                            }

                            if(x==4) {
                                System.out.println("----------------------Customer Details-------------");
                                System.out.println("Enter Customer Account Number : ");
                                String ac = sc.nextLine();


                                try{
                                    Customer cus = ad.viewCustomer(ac);

                                    if(cus!=null) {
                                        System.out.println("************************");
                                        System.out.println("Account Number : " + cus.getCustomerAccountNumber());
                                        System.out.println("Name : " + cus.getCustomerName());
                                        System.out.println("Balance : " + cus.getCustomerBalance());
                                        System.out.println("Email : " + cus.getCustomerEmail());
                                        System.out.println("Password : " + cus.getCustomerPassword());
                                        System.out.println("Mobile Number : " + cus.getCustomerMobileNo());
                                        System.out.println("Address : " + cus.getCustomerAddress());
                                        System.out.println("************************");
                                    }
                                    else {
                                        System.out.println("Account Does Not Exists!! ");
                                        System.out.println("-------------------------");

                                    }
                                }
                                catch(CustomerException e) {
                                    e.printStackTrace();
                                }

                            }

                            if(x==5) {

                                try {
                                    System.out.println("------------------All Customer List-----------------");

                                    Customer cu = ad.viewAllCustomer();
                                }
                                catch(CustomerException e) {
                                    e.printStackTrace();
                                }
                            }
                            if(x==6) {
                                System.out.println("Account Logout Successful!!");
                                y = false;
                            }
                        }
                        break;

                    } catch(AccountantException e) {
                        System.out.println(e.getMessage());
                    }
                    break; // case 1 break

                case 2:
                    System.out.println("CUSTOMER LOGIN----------------->>");
                    System.out.println("---------------------------------");
                    System.out.println("Enter UserName : ");
                    String customerUserName = sc.nextLine();
                    System.out.println("Enter Password : ");
                    String customerPassword = sc.nextLine();
                    System.out.println("Enter Account Number : ");
                    int accountNumber = Integer.parseInt(sc.nextLine());

                    CustomerDao cd = new CustomerDaoImplementation();


                    try {
                        Customer cus = cd.loginCustomer(customerUserName, customerPassword, accountNumber);
                        System.out.println("Welcome : " + cus.getCustomerName());

                        boolean m = true;

                        while(m) {

                            System.out.println("-----------------------------------------------\r\n"
                                    + "1. View Balance \r\n"
                                    + "2. Deposit Money \r\n"
                                    + "3. Withdraw Money \r\n"
                                    + "4. Transfer Money \r\n"
                                    + "5. Logout/r/n"
                            );

                            int x = Integer.parseInt(sc.nextLine());

                            if(x==1) {
                                System.out.println("-------------Balance-----------");
                                System.out.println("Current Account Balance ------");
                                System.out.println(cd.viewBalance(accountNumber));
                                System.out.println("-------------------------------");
                            }


                        }
                        break;

                    }
                    catch(CustomerException e) {
                        //e.printStackTrace();
                        System.out.println(e.getMessage());
                    }
            }
        }
    }
}
