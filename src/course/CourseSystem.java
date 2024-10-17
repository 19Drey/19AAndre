package course;
import java.util.Scanner;

public class CourseSystem {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String response;
            do {
                System.out.println("1. ADD COURSE");
                System.out.println("2. VIEW COURSES");
                System.out.println("3. UPDATE COURSE");
                System.out.println("4. DELETE COURSE");
                System.out.println("5. EXIT");
                
                System.out.print("Enter action: ");
                int action = sc.nextInt();
                sc.nextLine(); // Consume newline
                
                CourseSystem system = new CourseSystem();
                switch (action) {
                    case 1:
                        system.addCourse();
                        break;
                    case 2:
                        system.viewCourses();
                        break;
                    case 3:
                        system.updateCourse();
                        break;
                    case 4:
                        system.deleteCourse();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid action. Please choose a number between 1 and 5.");
                }
                
                if (action != 5) {
                    System.out.print("Do you want to continue? (yes/no): ");
                    response = sc.nextLine();
                } else {
                    response = "no"; // Exit loop if action is 5
                }
                
            } while (response.equalsIgnoreCase("yes"));
            System.out.println("Thank you, See you!!");
            // Close the scanner
        }
    }

    public void addCourse() {
        Scanner sc = new Scanner(System.in);
        Config conf = new Config();

        System.out.print("Course Name: ");
        String courseName = sc.nextLine();
        System.out.print("Course Code: ");
        String courseCode = sc.nextLine();
        System.out.print("Credits: ");
        int credits = sc.nextInt();
        System.out.print("Semester: ");
        String semester = sc.next();
        System.out.print("Year: ");
        int year = sc.nextInt();

        String sql = "INSERT INTO tbl_course (course_name, course_code, credits, semester, year) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, courseName, courseCode, credits, semester, year);
    }

    public void viewCourses() {
        Config conf = new Config();
        String qry = "SELECT * FROM tbl_course";
        String[] hdrs = {"Course ID", "Course Name", "Course Code", "Credits", "Semester", "Year"};
        String[] clmn = {"course_id", "course_name", "course_code", "credits", "semester", "year"};

        conf.viewRecords(qry, hdrs, clmn);
    }

    public void updateCourse() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.print("New Course Name: ");
        String newName = sc.nextLine();
        System.out.print("New Course Code: ");
        String newCode = sc.nextLine();
        System.out.print("New Credits: ");
        int newCredits = sc.nextInt();
        System.out.print("New Semester: ");
        String newSemester = sc.next();
        System.out.print("New Year: ");
        int newYear = sc.nextInt();

        String qry = "UPDATE tbl_course SET course_name = ?, course_code = ?, credits = ?, semester = ?, year = ? WHERE course_id = ?";
        Config conf = new Config();
        conf.updateRecord(qry, newName, newCode, newCredits, newSemester, newYear, id);
    }

    public void deleteCourse() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_course WHERE course_id = ?";
        Config conf = new Config();
        conf.deleteRecord(qry, id);
    }
}

class Config {
    // Implement database connection and execution methods here
    public void addRecord(String sql, Object... params) {
        // Execute INSERT statement with provided parameters
    }

    public void viewRecords(String qry, String[] headers, String[] columns) {
        // Execute SELECT statement and display records
    }

    public void updateRecord(String qry, Object... params) {
        // Execute UPDATE statement with provided parameters
    }

    public void deleteRecord(String qry, int id) {
        // Execute DELETE statement
    }
}
