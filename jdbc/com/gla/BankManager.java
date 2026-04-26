import java.sql.*;

public class BankManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // CREATE
            addAccount(conn, 101, "Amit", 15000);
            addAccount(conn, 102, "Riya", 8000);
            addAccount(conn, 103, "John", 25000);

            // READ
            displayHighBalance(conn);

            // UPDATE (Deposit & Withdraw)
            deposit(conn, 102, 5000);     // add money
            withdraw(conn, 101, 3000);    // subtract money

            // DELETE
            deleteAccount(conn, 102);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public static void addAccount(Connection conn, int accNo, String name, double balance) throws SQLException {
        String query = "INSERT INTO accounts VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, accNo);
        ps.setString(2, name);
        ps.setDouble(3, balance);

        ps.executeUpdate();
        System.out.println("Account created: " + name);
    }

    // READ
    public static void displayHighBalance(Connection conn) throws SQLException {
        String query = "SELECT * FROM accounts WHERE balance > 10000";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("\nAccounts with balance > 10000:");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("accNo") + " | " +
                            rs.getString("name") + " | " +
                            rs.getDouble("balance")
            );
        }
    }

    // UPDATE - Deposit
    public static void deposit(Connection conn, int accNo, double amount) throws SQLException {
        String query = "UPDATE accounts SET balance = balance + ? WHERE accNo = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setDouble(1, amount);
        ps.setInt(2, accNo);

        int rows = ps.executeUpdate();
        System.out.println("\nDeposited " + amount + " to Account: " + accNo + " Rows affected: " + rows);
    }

    // UPDATE - Withdraw
    public static void withdraw(Connection conn, int accNo, double amount) throws SQLException {
        // Check balance first
        String checkQuery = "SELECT balance FROM accounts WHERE accNo = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
        checkStmt.setInt(1, accNo);

        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            double currentBalance = rs.getDouble("balance");

            if (currentBalance >= amount) {
                String updateQuery = "UPDATE accounts SET balance = balance - ? WHERE accNo = ?";
                PreparedStatement ps = conn.prepareStatement(updateQuery);

                ps.setDouble(1, amount);
                ps.setInt(2, accNo);

                ps.executeUpdate();
                System.out.println("Withdrawn " + amount + " from Account: " + accNo);
            } else {
                System.out.println("Insufficient balance for Account: " + accNo);
            }
        }
    }

    // DELETE
    public static void deleteAccount(Connection conn, int accNo) throws SQLException {
        String query = "DELETE FROM accounts WHERE accNo = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, accNo);

        int rows = ps.executeUpdate();
        System.out.println("\nAccount deleted: " + accNo + " Rows affected: " + rows);
    }
}
