
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private ArrayList<Student> students;
    private Scanner scanner;

    
    public StudentManagement() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter PRN: ");
        String prn = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of Birth (DD/MM/YYYY): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Student student = new Student(prn, name, dob, marks);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        for (Student student : students) {
            student.display();
        }
    }

    public void searchByPrn() {
        System.out.print("Enter PRN to search: ");
        String prn = scanner.nextLine();
        for (Student student : students) {
            if (student.getPrn().equalsIgnoreCase(prn)) {
                student.display();
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

    public void searchByName() {
        System.out.print("Enter Name to search: ");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.display();
                return;
            }
        }
        System.out.println("Student with name " + name + " not found.");
    }

    public void updateStudent() {
        System.out.print("Enter PRN of the student to update: ");
        String prn = scanner.nextLine();
        for (Student student : students) {
            if (student.getPrn().equalsIgnoreCase(prn)) {
                System.out.print("Enter new Name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter new Date of Birth (DD/MM/YYYY): ");
                student.setDob(scanner.nextLine());
                System.out.print("Enter new Marks: ");
                student.setMarks(scanner.nextDouble());
                scanner.nextLine(); // Consume newline
                System.out.println("Student details updated successfully.");
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

    public void deleteStudent() {
        System.out.print("Enter PRN of the student to delete: ");
        String prn = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPrn().equalsIgnoreCase(prn)) {
                students.remove(i);
                System.out.println("Student with PRN " + prn + " deleted successfully.");
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

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
            choice = management.scanner.nextInt();
            management.scanner.nextLine(); // Consume newline

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
