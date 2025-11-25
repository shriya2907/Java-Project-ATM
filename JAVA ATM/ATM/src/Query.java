public class Query {
    static String add="INSERT into users(username,password,balance) values(?,?,?)";
    static String auth="SELECT * FROM users WHERE username = ? AND password = ?";
    static String balance="SELECT balance FROM users WHERE username = ?";
    static String deposite="UPDATE users SET balance = balance + ? WHERE username = ?";
    static String withdraw="UPDATE users SET balance = balance - ? WHERE username = ?";
}
