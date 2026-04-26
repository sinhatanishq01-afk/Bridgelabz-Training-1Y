import java.sql.*;

public class CustomerDirectory {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // CREATE
            addCustomer(conn, 1, "Rahul", "9876543210");
            addCustomer(conn, 2, "Riya", "9123456780");
            addCustomer(conn, 3, "Raj", "9988776655");

            // READ (Search by name)
            searchCustomer(conn, "Ra");

            // UPDATE
            updatePhone(conn, 1, "9999999999");

            // DELETE
            deleteCustomer(conn, 2);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public static void addCustomer(Connection conn, int id, String name, String phone) throws SQLException {
        String query = "INSERT INTO customers VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, phone);

        ps.executeUpdate();
        System.out.println("Customer added: " + name);
    }

    // READ (LIKE search)
    public static void searchCustomer(Connection conn, String keyword) throws SQLException {
        String query = "SELECT * FROM customers WHERE name LIKE ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, "%" + keyword + "%");

        ResultSet rs = ps.executeQuery();

        System.out.println("\nSearch Results:");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getString("phone")
            );
        }
    }

    // UPDATE
    public static void updatePhone(Connection conn, int id, String newPhone) throws SQLException {
        String query = "UPDATE customers SET phone = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, newPhone);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println("\nPhone updated for ID: " + id + " Rows affected: " + rows);
    }

    // DELETE
    public static void deleteCustomer(Connection conn, int id) throws SQLException {
        String query = "DELETE FROM customers WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println("\nCustomer deleted with ID: " + id + " Rows affected: " + rows);
    }
}
