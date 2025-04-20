CREATE DATABASE student_management;

USE student_management;

CREATE TABLE students (
    prn VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    dob DATE NOT NULL,
    marks DOUBLE CHECK (marks >= 0 AND marks <= 100)
);
