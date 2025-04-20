import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            calculator.displayMenu();
            System.out.print("Select an option (1-8): ");
            int choice = scanner.nextInt();

            if (choice == 8) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            if (choice >= 1 && choice <= 7) {
                calculator.getUser Input(choice);
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        scanner.close();
    }
}
