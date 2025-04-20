import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagement() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
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
            for (Student s : students) {
                if (s.getPrn().equalsIgnoreCase(prn)) {
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

            Student student = new Student(prn, name, dob, marks);
            students.add(student);
            System.out.println("Student added successfully.");
        } catch (InvalidPRNException | InvalidMarksException | InvalidDateFormatException | IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    // Display All Students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student student : students) {
            student.display();
        }
    }

    // Search by PRN
    public void searchByPrn() {
        try {
            System.out.print("Enter PRN to search: ");
            String prn = scanner.nextLine();
            if (prn == null || prn.trim().isEmpty()) {
                throw new EmptySearchFieldException("PRN cannot be empty.");
            }

            for (Student student : students) {
                if (student.getPrn().equalsIgnoreCase(prn)) {
                    student.display();
                    return;
                }
            }
            throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
        } catch (EmptySearchFieldException | StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Search by Name
    public void searchByName() {
        try {
            System.out.print("Enter Name to search: ");
            String name = scanner.nextLine();
            if (name == null || name.trim().isEmpty()) {
                throw new EmptySearchFieldException("Name cannot be empty.");
            }

            for (Student student : students) {
                if (student.getName().equalsIgnoreCase(name)) {
                    student.display();
                    return;
                }
            }
            throw new StudentNotFoundException("Student with name " + name + " not found.");
        } catch (EmptySearchFieldException | StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Update Student
    public void updateStudent() {
        try {
            System.out.print("Enter PRN of the student to update: ");
            String prn = scanner.nextLine();
            if (prn == null || prn.trim().isEmpty()) {
                throw new EmptyPRNException("PRN cannot be empty.");
            }

            boolean found = false;
            for (Student student : students) {
                if (student.getPrn().equalsIgnoreCase(prn)) {
                    found = true;

                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    if (newName == null || newName.trim().isEmpty()) {
                        throw new IllegalArgumentException("Name cannot be empty.");
                    }
                    student.setName(newName);

                    System.out.print("Enter new Date of Birth (DD/MM/YYYY): ");
                    String newDob = scanner.nextLine();
                    if (!newDob.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        throw new InvalidDateFormatException("Date of Birth must be in DD/MM/YYYY format.");
                    }
                    student.setDob(newDob);

                    System.out.print("Enter new Marks: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    if (newMarks < 0 || newMarks > 100) {
                        throw new InvalidMarksException("Marks must be between 0 and 100.");
                    }
                    student.setMarks(newMarks);

                    System.out.println("Student details updated successfully.");
                    break;
                }
            }
            if (!found) {
                throw new UpdateFailedException("Student with PRN " + prn + " not found.");
            }
        } catch (EmptyPRNException | UpdateFailedException | InvalidDateFormatException | InvalidMarksException | IllegalArgumentException e) {
            System.out.println("Error updating student: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    // Delete Student
    public void deleteStudent() {
        try {
            System.out.print("Enter PRN of the student to delete: ");
            String prn = scanner.nextLine();
            if (prn == null || prn.trim().isEmpty()) {
                throw new EmptyPRNException("PRN cannot be empty.");
            }

            boolean removed = false;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getPrn().equalsIgnoreCase(prn)) {
                    students.remove(i);
                    removed = true;
                    System.out.println("Student with PRN " + prn + " deleted successfully.");
                    break;
                }
            }
            if (!removed) {
                throw new DeleteFailedException("Student with PRN " + prn + " not found.");
            }
        } catch (EmptyPRNException | DeleteFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    // Main Method
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        int choice;

        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(management.scanner.nextLine()); // safer input parsing
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    management.addStudent();
                    break;
                case 2:
                    management.displayStudents();
                    break;
                case 3:
                    management.searchByPrn();
                    break;
                case 4:
                    management.searchByName();
                    break;
                case 5:
                    management.updateStudent();
                    break;
                case 6:
                    management.deleteStudent();
                    break;
                case 7:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 7);

        management.scanner.close();
    }
}
