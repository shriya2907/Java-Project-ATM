<h1 align="center">Console-Based ATM System (SBI ATM Simulator)</h1>

<p>
A simple console-based ATM application built using <b>Java</b> and <b>MySQL</b>. 
This project demonstrates essential ATM operations such as user authentication, deposit, withdrawal, and balance enquiry with persistent storage using JDBC.
</p>

<hr/>

<h2>📌 Features</h2>
<ul>
    <li><b>User Authentication:</b> Login using username and password stored in MySQL database.</li>
    <li><b>Deposit Money:</b> Adds a valid amount to the account balance.</li>
    <li><b>Withdrawal:</b> Deducts money after checking sufficient balance.</li>
    <li><b>Balance Enquiry:</b> Retrieves real-time balance from database.</li>
</ul>

<hr/>

<h2>🏗️ Project Structure</h2>

<pre>
src/
 ├── App.java      (Main class - User interface & menu)
 ├── Atm.java      (ATM logic - deposit, withdrawal, authenticate)
 ├── DB.java       (MySQL JDBC Connection)
 └── Query.java    (SQL Query Strings)
</pre>

<hr/>

<h2>🛠️ Technologies Used</h2>
<ul>
    <li>Java (JDK 8 or above)</li>
    <li>MySQL Database</li>
    <li>JDBC (Java Database Connectivity)</li>
    <li>Any IDE (IntelliJ, Eclipse, VS Code) or CLI</li>
</ul>

<hr/>

<h2>🗄️ Database Setup</h2>

<pre>
CREATE DATABASE Bank;

USE Bank;

CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    balance DOUBLE NOT NULL
);

INSERT INTO users (username, password, balance) VALUES
('user1', 'pass1', 5000),
('user2', 'pass2', 10000);
</pre>

<p><b>Update DB.java with your MySQL credentials:</b></p>

<pre>
String url  = "jdbc:mysql://localhost:3306/Bank";
String user = "root";
String pass = "YOUR_PASSWORD";
</pre>

<hr/>

<h2>▶️ How to Run</h2>

<h3>Option 1: Run using IDE</h3>
<ol>
    <li>Open project in IDE.</li>
    <li>Add <b>mysql-connector-j</b> JAR to classpath.</li>
    <li>Ensure MySQL server is running.</li>
    <li>Run <b>App.java</b>.</li>
</ol>

<h3>Option 2: Run using Command Line</h3>

<pre>
javac -cp .;path/to/mysql-connector.jar App.java Atm.java DB.java Query.java
java  -cp .;path/to/mysql-connector.jar App
</pre>

<hr/>

<h2>🧪 Testing Instructions</h2>
<ul>
    <li>Test valid/invalid login.</li>
    <li>Deposit valid and invalid amounts.</li>
    <li>Withdraw with sufficient and insufficient balance.</li>
    <li>Check balance after transactions.</li>
</ul>

<hr/>

<h2>📸 Screenshots (Optional)</h2>
<p>Add your screenshots in a <code>screenshots/</code> folder and embed like:</p>

<pre>
&lt;img src="screenshots/login.png" width="500"/&gt;
</pre>

<hr/>

<h2>🚧 Limitations & Future Enhancements</h2>
<ul>
    <li>Passwords stored in plain text (can be hashed in future).</li>
    <li>No transaction history.</li>
    <li>No GUI (only console interface).</li>
    <li>No user registration from console.</li>
</ul>

<h3>Possible Improvements</h3>
<ul>
    <li>Add password hashing</li>
    <li>Add transaction history table</li>
    <li>Add GUI using JavaFX/Swing</li>
    <li>Add multi-account support</li>
</ul>

<hr/>

<h2>📜 License</h2>
<p>This project is created for educational purposes as part of the VIT flipped classroom evaluation.</p>
