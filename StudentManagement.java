import java.sql.*;
import java.util.Scanner;


// Student Management Class
public class StudentManagement {
    private Connection connection;
    private Scanner scanner;

    public StudentManagement() {
        scanner = new Scanner(System.in);
        try {
            // Establish connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ass_9", "root", "12345678");
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    // Add Student
    public void addStudent() {
        try {
            System.out.print("Enter PRN: ");
            String prn = scanner.nextLine().trim();
            if (prn.isEmpty()) throw new InvalidPRNException("PRN cannot be empty.");

            // Check if PRN already exists
            String checkQuery = "SELECT * FROM students WHERE prn = ?";
            try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
                checkStmt.setString(1, prn);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) throw new InvalidPRNException("PRN already exists.");
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

            System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine().trim();
            if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) throw new InvalidDateFormatException("Date of Birth must be in YYYY-MM-DD format.");

            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            if (marks < 0 || marks > 100) throw new InvalidMarksException("Marks must be between 0 and 100.");

            String insertQuery = "INSERT INTO students (prn, name, dob, marks) VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                insertStmt.setString(1, prn);
                insertStmt.setString(2, name);
                insertStmt.setDate(3, Date.valueOf(dob));
                insertStmt.setDouble(4, marks);
                insertStmt.executeUpdate();
                System.out.println("Student added successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (InvalidPRNException | InvalidMarksException | InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Display All Students
    public void displayStudents() {
        try {
            String selectQuery = "SELECT * FROM students";
            try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("No students to display.");
                    return;
                }
                while (rs.next()) {
                    System.out.println("PRN: " + rs.getString("prn") + ", Name: " + rs.getString("name") +
                            ", DOB: " + rs.getDate("dob") + ", Marks: " + rs.getDouble("marks"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error displaying students: " + e.getMessage());
        }
    }

    // Search Student by PRN
    public void searchStudent() {
        try {
            System.out.print("Enter PRN to search: ");
            String prn = scanner.nextLine().trim();
            if (prn.isEmpty()) throw new EmptySearchFieldException("Search field cannot be empty.");

            String query = "SELECT * FROM students WHERE prn = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, prn);
                ResultSet rs = stmt.executeQuery();
                if (!rs.next()) throw new StudentNotFoundException("Student not found.");
                System.out.println("PRN: " + rs.getString("prn") + ", Name: " + rs.getString("name") +
                        ", DOB: " + rs.getDate("dob") + ", Marks: " + rs.getDouble("marks"));
            }
        } catch (SQLException | StudentNotFoundException | EmptySearchFieldException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update Student Marks
    public void updateMarks() {
        try {
            System.out.print("Enter PRN to update: ");
            String prn = scanner.nextLine().trim();
            if (prn.isEmpty()) throw new EmptySearchFieldException("PRN cannot be empty.");

            System.out.print("Enter new marks: ");
            double newMarks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            if (newMarks < 0 || newMarks > 100) throw new InvalidMarksException("Marks must be between 0 and 100.");

            String updateQuery = "UPDATE students SET marks = ? WHERE prn = ?";
            try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
                stmt.setDouble(1, newMarks);
                stmt.setString(2, prn);
                int rows = stmt.executeUpdate();
                if (rows == 0) throw new UpdateFailedException("Update failed. Student not found.");
                System.out.println("Marks updated successfully.");
            }
        } catch (SQLException | InvalidMarksException | UpdateFailedException | EmptySearchFieldException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Delete Student
    public void deleteStudent() {
        try {
            System.out.print("Enter PRN to delete: ");
            String prn = scanner.nextLine().trim();
            if (prn.isEmpty()) throw new EmptySearchFieldException("PRN cannot be empty.");

            String deleteQuery = "DELETE FROM students WHERE prn = ?";
            try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
                stmt.setString(1, prn);
                int rows = stmt.executeUpdate();
                if (rows == 0) throw new DeleteFailedException("Delete failed. Student not found.");
                System.out.println("Student deleted successfully.");
            }
        } catch (SQLException | DeleteFailedException | EmptySearchFieldException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Main Menu
    public void run() {
        int choice;
        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by PRN");
            System.out.println("4. Update Student Marks");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> searchStudent();
                case 4 -> updateMarks();
                case 5 -> deleteStudent();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    public static void main(String[] args) {
        new StudentManagement().run();
    }
}
