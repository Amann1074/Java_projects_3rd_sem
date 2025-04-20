

# Calculator Project

This is a simple command-line calculator application implemented in Java. The calculator supports basic operations such as addition, subtraction, multiplication, and division, as well as more advanced operations like square, cube, and square root.

## Features
- **Addition**: Adds two numbers.
- **Subtraction**: Subtracts the second number from the first.
- **Multiplication**: Multiplies two numbers.
- **Division**: Divides the first number by the second (handles division by zero).
- **Square**: Squares a given number.
- **Cube**: Cubes a given number.
- **Square Root**: Calculates the square root of a number (handles negative input).

## How to Run

### Prerequisites
Ensure you have the following installed:
- **Java** (JDK 8 or higher)
  - You can download Java from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

### Steps
1. Clone the repository or download the files.
2. Open a terminal and navigate to the project directory.
3. Compile the Java files using the following command:

   ```bash
   javac *.java
   ```

4. Run the program using:

   ```bash
   java Main
   ```

5. The program will display a menu with options. You can select an operation and input the numbers for the calculation.

### Example Output

```bash
Calculator Menu:
1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Square
6. Cube
7. Square Root
8. Exit

Select an option (1-8): 1
Enter first number: 5
Enter second number: 3
Result: 8.0
```

### Exit the Calculator
To exit the calculator, select option `8` from the menu.

## Exception Handling

The program handles the following exceptions:
- **ArithmeticException**: Occurs when attempting to divide by zero.
- **IllegalArgumentException**: Occurs when attempting to compute the square root of a negative number.
- **InputMismatchException**: Catches invalid user input (non-numeric values).

## Code Structure

The project consists of three main classes:

### `Main.java`
- The entry point of the application that displays the menu and interacts with the user.

### `Calculator.java`
- Contains the logic for displaying the menu and processing user inputs.
- Calls methods from the `Operations.java` class to perform the required operations.

### `Operations.java`
- Contains methods to perform mathematical operations such as addition, subtraction, multiplication, division, square, cube, and square root.

## Contributing

Feel free to fork the repository and submit pull requests for any improvements or new features.
