import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// import java.sql.SQLException;

public class Atm {
    public static void addNewUser(String uname,String pass,double bal){
        try(Connection conn=DB.connect()){
            String query=Query.add;
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pass);
            ps.setDouble(3, bal);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User added Successfully !!");
            } else {
                System.out.println("Something went Wrong !");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static boolean authenticate(String username, String password) {
        try (Connection conn = DB.connect()) {
            String query = Query.auth;
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void deposit(String username, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        String query = "UPDATE users SET balance = balance + ? WHERE username = ?";
        try (Connection conn = DB.connect()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDouble(1, amount); // Set deposit amount
            ps.setString(2, username); // Set username

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Deposit successful! Your new balance is updated.");
            } else {
                System.out.println("User not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void withdraw(String username, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        String checkBalanceQuery = Query.balance;
        String updateBalanceQuery = Query.withdraw;

        try (Connection conn = DB.connect()) {
            // Check the user's balance
            PreparedStatement checkPs = conn.prepareStatement(checkBalanceQuery);
            checkPs.setString(1, username);
            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");

                // If balance is sufficient, proceed with withdrawal
                if (currentBalance >= amount) {
                    PreparedStatement updatePs = conn.prepareStatement(updateBalanceQuery);
                    updatePs.setDouble(1, amount); // Set withdrawal amount
                    updatePs.setString(2, username); // Set username

                    int rowsUpdated = updatePs.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Withdrawal successful! Your new balance is updated.");
                    }
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("User not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double getBalance(String username) {
        String query = Query.balance;
        try (Connection conn = DB.connect()) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username); // Set username

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                double balance = rs.getDouble("balance");
                return balance;
            } else {
                return -1; // Return -1 if user is not found
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Return -1 if an error occurs
        }
    }

}