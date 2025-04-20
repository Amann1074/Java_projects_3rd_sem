import java.sql.*;
import java.util.Scanner;

public class StudentManagement {
    private Connection connection;
    private Scanner scanner;

    public StudentManagement() {
        scanner = new Scanner(System.in);
        try {
            // Establish connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "username", "password");
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
    }

    // Add Student
    public void addStudent() {
        try {
            System.out.print("Enter PRN: ");
            String prn = scanner.nextLine();
            if (prn == null || prn.trim().isEmpty()) {
                throw new InvalidPRNException("PRN cannot be empty.");
            }

            // Check if PRN already exists
            String checkQuery = "SELECT * FROM students WHERE prn = ?";
            try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
                checkStmt.setString(1, prn);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    throw new InvalidPRNException("PRN already exists.");
                }
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            }

            System.out.print("Enter Date of Birth (DD/MM/YYYY): ");
            String dob = scanner.nextLine();
            if (!dob.matches("\\d{2}/\\d{2}/\\d{4}")) {
                throw new InvalidDateFormatException("Date of Birth must be in DD/MM/YYYY format.");
            }

            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            if (marks < 0 || marks > 100) {
                throw new InvalidMarksException("Marks must be between 0 and 100.");
            }

            // Insert student into the database
            String insertQuery = "INSERT INTO students (prn, name, dob, marks) VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                insertStmt.setString(1, prn);
                insertStmt.setString(2, name);
                insertStmt.setDate(3, Date.valueOf(dob.replace("/", "-"))); // Convert to SQL Date
                insertStmt.setDouble(4, marks);
                insertStmt.executeUpdate();
                System.out.println("Student added successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (InvalidPRNException | InvalidMarksException | InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
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
                    String prn =
