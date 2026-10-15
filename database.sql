CREATE DATABASE student_management;

USE student_management;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    course VARCHAR(100) NOT NULL,
    age INT NOT NULL
);

INSERT INTO students (name, email, course, age)
VALUES
('Rahul Kumar', 'rahul@gmail.com', 'BCA', 22),
('Aman Singh', 'aman@gmail.com', 'BCA', 21),
('Priya Sharma', 'priya@gmail.com', 'BCA', 22);

SELECT * FROM students;