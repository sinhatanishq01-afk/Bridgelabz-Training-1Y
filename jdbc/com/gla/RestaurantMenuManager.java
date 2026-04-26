import java.sql.*;

public class RestaurantMenuManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // CREATE
            addItem(conn, 1, "Burger", 120);
            addItem(conn, 2, "Pizza", 250);
            addItem(conn, 3, "Pasta", 180);

            // READ
            showAffordableItems(conn);

            // UPDATE
            updatePrice(conn, 2, 220);

            // DELETE
            deleteItem(conn, 3);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public static void addItem(Connection conn, int id, String itemName, double price) throws SQLException {
        String query = "INSERT INTO menu VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);
        ps.setString(2, itemName);
        ps.setDouble(3, price);

        ps.executeUpdate();
        System.out.println("Item added: " + itemName);
    }

    // READ
    public static void showAffordableItems(Connection conn) throws SQLException {
        String query = "SELECT * FROM menu WHERE price < 200";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("\nMenu items priced below ₹200:");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("itemName") + " | ₹" +
                            rs.getDouble("price")
            );
        }
    }

    // UPDATE
    public static void updatePrice(Connection conn, int id, double newPrice) throws SQLException {
        String query = "UPDATE menu SET price = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setDouble(1, newPrice);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println("\nPrice updated for item ID: " + id + " Rows affected: " + rows);
    }

    // DELETE
    public static void deleteItem(Connection conn, int id) throws SQLException {
        String query = "DELETE FROM menu WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println("\nItem deleted with ID: " + id + " Rows affected: " + rows);
    }
}
