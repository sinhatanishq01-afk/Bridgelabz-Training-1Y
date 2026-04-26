import java.sql.*;

public class EmployeeManager {

    // Database credentials
    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // 1. ADD Employee
            addEmployee(conn, 1, "Amit", 35000);
            addEmployee(conn, 2, "Riya", 12000);
            addEmployee(conn, 3, "John", 50000);

            // 2. READ Employees with salary > 30000
            displayHighSalary(conn);

            // 3. UPDATE salary by 10%
            increaseSalary(conn, 1);

            // 4. DELETE employees with salary < 15000
            deleteLowSalary(conn);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public static void addEmployee(Connection conn, int id, String name, double salary) throws SQLException {
        String query = "INSERT INTO employee VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setDouble(3, salary);

        ps.executeUpdate();
        System.out.println("Employee added: " + name);
    }

    // READ
    public static void displayHighSalary(Connection conn) throws SQLException {
        String query = "SELECT * FROM employee WHERE salary > 30000";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("\nEmployees with salary > 30000:");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getDouble("salary")
            );
        }
    }

    // UPDATE
    public static void increaseSalary(Connection conn, int empId) throws SQLException {
        String query = "UPDATE employee SET salary = salary * 1.10 WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, empId);

        int rows = ps.executeUpdate();
        System.out.println("\nSalary updated for employee ID: " + empId + " Rows affected: " + rows);
    }

    // DELETE
    public static void deleteLowSalary(Connection conn) throws SQLException {
        String query = "DELETE FROM employee WHERE salary < 15000";
        Statement stmt = conn.createStatement();

        int rows = stmt.executeUpdate(query);
        System.out.println("\nDeleted employees with salary < 15000. Rows affected: " + rows);
    }
}
