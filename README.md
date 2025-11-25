# Console-Based ATM System (SBI ATM Simulator)

A simple console-based ATM application built in **Java** with **MySQL** as the backend database.  
The project simulates basic ATM operations such as user authentication, deposit, withdrawal, and balance enquiry using JDBC.

---

## 📌 Features

- **User Authentication**
  - Login using a valid username and password.
  - Credentials validated against records stored in the MySQL `users` table.

- **Deposit**
  - Deposit a valid positive amount.
  - Updates the account balance in the database.

- **Withdrawal**
  - Withdraw a valid positive amount.
  - Checks for sufficient balance before updating.
  - Displays “Insufficient balance” when funds are not enough.

- **Balance Enquiry**
  - Fetches current balance from the database and displays it to the user.

---

## 🏗️ Project Structure

```text
src/
 ├── App.java      // Main class: handles user interaction & menu
 ├── Atm.java      // ATM logic: authenticate, deposit, withdraw, getBalance
 ├── DB.java       // Database connection using JDBC (MySQL)
 └── Query.java    // Centralized SQL query strings
