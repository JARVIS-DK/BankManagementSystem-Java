# Online Banking System

## Overview

This project is a **console-based banking management system** implemented in Java. It provides functionalities for both administrators (accountants) and customers to perform various banking operations such as account management, balance inquiries, deposits, withdrawals, and fund transfers.

---

## Features

### 1. **Admin (Accountant) Portal**

- Login as an accountant using valid credentials.
- Manage customer accounts:
  - Add new customer accounts.
  - Add new customer accounts.
  - Delete customer accounts.
  - View individual or all customer details.

### 2. **Customer Portal**

- Login as a customer using valid credentials (username, password, and account number).
- Perform banking operations:
  - View account balance.
  - Deposit money.
  - Withdraw money.
  - Transfer money to another account.

---

## Project Structure

```plaintext
src/
├── com/system/bank/
│   ├── App.java
│   ├── dao/
│   │   ├── AccountantDao.java
│   │   ├── AccountantDaoImplementation.java
│   │   ├── CustomerDao.java
│   │   ├── CustomerDaoImplementation.java
|   └── dbconnection/
|       ├── DataBaseConnection.java
│   └── entity/
│       ├── Accountant.java
│       ├── Customer.java
│   └── exception/
│       ├── AccountantException.java
│       ├── CustomerException.java
```

---

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/JARVIS-DK/BankManagementSystem-Java.git
   ```

2. Navigate to the project directory:

   ```bash
   cd BankManagementSystem-Java
   ```

3. Compile the project:

   ```bash
   javac -d bin src/com/system/bank/*.java src/com/system/bank/dao/*.java src/com/system/bank/entity/*.java src/com/system/bank/exception/*.java
   ```

4. Run the application:

   ```bash
   java -cp bin com.system.bank.App
   ```

---

## Usage Instructions

### Admin (Accountant) Login

- Enter the username and password as prompted.
- Once logged in, you can:
  - Add, update, or delete customer accounts.
  - View customer account details.
  - Logout to return to the main menu.

### Customer Login

- Enter your username, password, and account number as prompted.
- Once logged in, you can:
  - View your account balance.
  - Deposit or withdraw money.
  - Transfer money to another account.
  - Logout to return to the main menu.

---

## Classes and Interfaces

### 1. **Entity Classes**

- `Accountant`:
  - Represents the admin user with attributes such as username and password.
- `Customer`:
  - Represents the customer with attributes such as account number, name, balance, email, and address.

### 2. **DAO Interfaces and Implementations**

- `AccountantDao` and `AccountantDaoImplementation`:
  - Define and implement methods for managing admin and customer operations.
- `CustomerDao` and `CustomerDaoImplementation`:
  - Define and implement methods for customer operations like balance inquiry, deposit, withdrawal, and transfer.

### 3. **Exception Classes**

- `AccountantException`:
  - Handles errors specific to admin operations.
- `CustomerException`:
  - Handles errors specific to customer operations.

---

## Example Scenarios

### Admin Operations

1. **Login as Admin**:
   ```plaintext
   Enter UserName: admin
   Enter Password: password
   Login Successfully!!
   ```
2. **Add a New Customer**:
   ```plaintext
   Enter Customer Name: John Doe
   Enter Account Opening Balance: 5000
   Enter Customer Email: john@example.com
   Enter Customer Password: password123
   Enter Customer Mobile Number: 1234567890
   Enter Customer Address: 123 Main St
   Customer Added Successfully!
   ```

### Customer Operations

1. **Login as Customer**:
   ```plaintext
   Enter UserName: john_doe
   Enter Password: password123
   Enter Account Number: 101
   Welcome: John Doe
   ```
2. **View Balance**:
   ```plaintext
   Current Account Balance ------
   5000
   ```

---



## License

This project is licensed under the MIT License. See the LICENSE file for details.

---

## Author

**JARVIS-DK**

- [GitHub Profile](https://github.com/JARVIS-DK)

