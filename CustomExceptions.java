// Exceptions for Add Student
class InvalidPRNException extends Exception {
    public InvalidPRNException(String message) {
        super(message);
    }
}

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) {
        super(message);
    }
}

// Exceptions for Search Student
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class EmptySearchFieldException extends Exception {
    public EmptySearchFieldException(String message) {
        super(message);
    }
}

// Exceptions for Update Student
class UpdateFailedException extends Exception {
    public UpdateFailedException(String message) {
        super(message);
    }
}

class InvalidDateFormatException extends Exception {
    public InvalidDateFormatException(String message) {
        super(message);
    }
}

// Exceptions for Delete Student
class DeleteFailedException extends Exception {
    public DeleteFailedException(String message) {
        super(message);
    }
}

class EmptyPRNException extends Exception {
    public EmptyPRNException(String message) {
        super(message);
    }
}
