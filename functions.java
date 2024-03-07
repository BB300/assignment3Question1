import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class functions {
public static ArrayList<Student> getAllStudents() throws SQLException {
    var students = new ArrayList<Student>();
    //This sql statement represents the commands necessary to gets all of the students from the table.
    var sql = "SELECT student_id, first_name, last_name, email, enrollment_date FROM students ORDER BY last_name";
    var connect = DB.connect();
         var statement = connect.createStatement();
         var rs = statement.executeQuery(sql);
         //This while loop goes through the list and adds every student to students.
         while (rs.next()) {
             var student = new Student (
                     rs.getInt("student_id"),
                     rs.getString("first_name"),
                     rs.getString("last_name"),
                     rs.getString("email"),
                     rs.getString("enrollment_date"));
             students.add(student);

         }
    return students;

        }
    public static int addStudent(String first_name, String last_name, String email, String enrollment_date) {
        var sql = "INSERT INTO students(first_name, last_name, email, enrollment_date) "
                + "VALUES(?,?,?,?::date)";
        try (var connect =  DB.connect();
             var update = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            update.setString(1, first_name);
            update.setString(2, last_name);
            update.setString(3, email);
            update.setString(4, enrollment_date);

            int insertedRow = update.executeUpdate();
            if (insertedRow > 0) {
                var rs = update.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        catch (SQLException e) {
                e.printStackTrace();
            }
        return -1;

    }

    public static int updateStudentEmail(int student_id, String new_email) {
        //This sql statement represents the commands necessary to update the appropriate student's
        //email address.
        var sql = "UPDATE students "
                + "SET email = ? "
                + "WHERE student_id = ?";

        int rows = 0;
        //Ths code find the appropriate student using the studnet ID and changes the email address
        //to new_email. 
        try (var connect = DB.connect();
             var update = connect.prepareStatement(sql)) {

            update.setString(1, new_email);
            update.setInt(2, student_id);

             rows = update.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;

    }

    public static int delete (int id) {

    var sql  = "DELETE FROM students WHERE student_id=?";
    try (var connect  = DB.connect();
         var update = connect.prepareStatement(sql)) {

         update.setInt(1, id);
         return update.executeUpdate();
    }
    catch (SQLException e) {
        e.printStackTrace();
    }

        return 0;
    }

}