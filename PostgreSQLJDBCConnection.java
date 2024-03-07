
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class PostgreSQLJDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";
        try { // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");
// Connect to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println(functions.getAllStudents());
                functions.addStudent("Benjamin", "Bhashyam", "benbhashyam@example.ca", "2022-10-05");
                System.out.println(functions.getAllStudents());
                functions.updateStudentEmail(2, "jane.smith@googlemail.com");
                System.out.println(functions.getAllStudents());
                functions.delete(4);
               System.out.println(functions.getAllStudents());
            } else {
                System.out.println("Failed to establish connection.");
            } // Close the connection (in a real scenario, do this in a finally
            conn.close();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        }
}