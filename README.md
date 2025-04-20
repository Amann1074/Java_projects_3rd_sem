
# Student Management System

## Overview

This is a simple **Student Management System** implemented in Java. It allows users to manage student records with functionalities such as adding, displaying, searching, updating, and deleting students. The system uses **custom exceptions** to handle invalid inputs and error scenarios effectively, providing robust and user-friendly error handling.

---

## Features

- Add a new student with PRN, Name, Date of Birth, and Marks.
- Display all student records.
- Search students by PRN or Name.
- Update student details by PRN.
- Delete student records by PRN.
- Input validation with custom exceptions for:
  - Empty or duplicate PRN.
  - Invalid marks (must be between 0 and 100).
  - Invalid date format (must be DD/MM/YYYY).
  - Empty search fields.
  - Student not found scenarios.
- Graceful error handling with meaningful messages.

---

## Project Structure

| File Name           | Description                                  |
|---------------------|----------------------------------------------|
| `Student.java`      | Defines the `Student` class with attributes and methods. |
| `CustomExceptions.java` | Contains all custom exception classes used for input validation and error handling. |
| `StudentManagement.java` | Contains the main class with student management functionalities and the program entry point. |

---

## Prerequisites

- Java Development Kit (JDK) 8 or above installed.
- Basic understanding of Java and command line.

---

## How to Compile and Run

1. Save all three files (`Student.java`, `CustomExceptions.java`, `StudentManagement.java`) in the same directory.

2. Open terminal/command prompt and navigate to the directory containing the files.

3. Compile the Java files:

   ```bash
   javac Student.java CustomExceptions.java StudentManagement.java
   ```

4. Run the Student Management System:

   ```bash
   java StudentManagement
   ```

---

## Usage

After running the program, you will see a menu:

```
--- Student Management System ---
1. Add Student
2. Display Students
3. Search by PRN
4. Search by Name
5. Update Student
6. Delete Student
7. Exit
Enter your choice:
```

- Enter the number corresponding to the operation you want to perform.
- Follow on-screen prompts to enter student details or search criteria.
- The system will validate inputs and display appropriate messages for errors or successful operations.
- To exit, choose option `7`.

---

## Example

```
Enter your choice: 1
Enter PRN: 12345
Enter Name: John Doe
Enter Date of Birth (DD/MM/YYYY): 15/08/2000
Enter Marks: 85
Student added successfully.
```

---

## Custom Exceptions Used

- `InvalidPRNException` — Thrown when PRN is empty or duplicate.
- `InvalidMarksException` — Thrown when marks are out of valid range.
- `InvalidDateFormatException` — Thrown when DOB format is invalid.
- `EmptySearchFieldException` — Thrown when search input is empty.
- `StudentNotFoundException` — Thrown when searched student is not found.
- `UpdateFailedException` — Thrown when update operation fails.
- `DeleteFailedException` — Thrown when delete operation fails.
- `EmptyPRNException` — Thrown when PRN input is empty during update/delete.

---

## Notes

- Date of Birth must be entered in the format `DD/MM/YYYY`.
- Marks must be a number between 0 and 100.
- PRN must be unique for each student.
- The system currently stores data in memory (no file/database persistence).

---

