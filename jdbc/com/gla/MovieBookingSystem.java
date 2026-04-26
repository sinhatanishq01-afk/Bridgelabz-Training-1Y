import java.sql.*;

public class MovieBookingSystem {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // CREATE
            addMovie(conn, 1, "Avengers", 50);
            addMovie(conn, 2, "Inception", 0);
            addMovie(conn, 3, "Interstellar", 30);

            // READ
            showAvailableMovies(conn);

            // UPDATE (Book ticket)
            bookTicket(conn, 1, 5); // booking 5 seats

            // DELETE
            deleteMovie(conn, 2);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public static void addMovie(Connection conn, int id, String name, int seats) throws SQLException {
        String query = "INSERT INTO movies VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, seats);

        ps.executeUpdate();
        System.out.println("Movie added: " + name);
    }

    // READ
    public static void showAvailableMovies(Connection conn) throws SQLException {
        String query = "SELECT * FROM movies WHERE seats > 0";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("\nAvailable Movies:");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " | " +
                            rs.getString("name") + " | Seats: " +
                            rs.getInt("seats")
            );
        }
    }

    // UPDATE (Book ticket)
    public static void bookTicket(Connection conn, int movieId, int seatsToBook) throws SQLException {

        // Check available seats
        String checkQuery = "SELECT seats FROM movies WHERE id = ?";
        PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
        checkStmt.setInt(1, movieId);

        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) {
            int availableSeats = rs.getInt("seats");

            if (availableSeats >= seatsToBook) {
                String updateQuery = "UPDATE movies SET seats = seats - ? WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(updateQuery);

                ps.setInt(1, seatsToBook);
                ps.setInt(2, movieId);

                ps.executeUpdate();
                System.out.println("Booked " + seatsToBook + " seats for movie ID: " + movieId);
            } else {
                System.out.println("Not enough seats available!");
            }
        } else {
            System.out.println("Movie not found!");
        }
    }

    // DELETE
    public static void deleteMovie(Connection conn, int movieId) throws SQLException {
        String query = "DELETE FROM movies WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, movieId);

        int rows = ps.executeUpdate();
        System.out.println("\nMovie deleted with ID: " + movieId + " Rows affected: " + rows);
    }
}
