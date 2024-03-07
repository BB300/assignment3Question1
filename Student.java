public class Student {
    private int student_id;
    private String first_name;
    private String last_name;
    private String email;

    private String enrollment_date;
    public Student(int student_id, String first_name, String last_name, String email, String enrollment_date) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.enrollment_date = enrollment_date;
    }
    public int getStudentId() {
        return student_id;
    }
    public String getFirstName() {
        return first_name;
    }
    public String getLastName(){
        return last_name;
    }
    public String email() {
        return email;
    }
    public String enrollment_date() {
        return enrollment_date;
    }
    public String toString() {
        return "Student{" +
                "id=" + student_id +
                ", First name='" + first_name + '\'' +
                ", Last name=" + last_name + '\'' +
                ", Email=" + email + '\'' +
                ", Enrollment date=" + enrollment_date +
                '}';
    }
}
