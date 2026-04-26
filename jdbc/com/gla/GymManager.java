import java.sql.*;

public class GymManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // CREATE
            addMember(conn, 1, "Amit", "Premium", 6);
            addMember(conn, 2, "Riya", "Basic", 3);
            addMember(conn, 3, "John", "Premium", 12);

            // READ
            showPremiumMembers(conn);

            // UPDATE (Extend membership)
            extendMembership(conn, 2, 2); // extend by 2 months

            // DELETE (Expired memberships)
            deleteExpiredMembers(conn);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public static void addMember(Connection conn, int id, String name, String type, int months) throws SQLException {
        String query = "INSERT INTO members VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, type);
        ps.setInt(4, months);

        ps.executeUpdate();
        System.out.println("Member added: " + name);
    }

    // READ
    public static void showPremiumMembers(Connection conn) throws SQLException {
        String query = "SELECT * FROM members WHERE type = 'Premium'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("\nPremium Members:");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("name") + " | " +
                            rs.getString("type") + " | Months: " +
                            rs.getInt("months")
            );
        }
    }

    // UPDATE
    public static void extendMembership(Connection conn, int id, int extraMonths) throws SQLException {
        String query = "UPDATE members SET months = months + ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, extraMonths);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println("\nMembership extended for ID: " + id + " Rows affected: " + rows);
    }

    // DELETE (Expired memberships: months <= 0)
    public static void deleteExpiredMembers(Connection conn) throws SQLException {
        String query = "DELETE FROM members WHERE months <= 0";
        Statement stmt = conn.createStatement();

        int rows = stmt.executeUpdate(query);
        System.out.println("\nExpired memberships removed. Rows affected: " + rows);
    }
}
