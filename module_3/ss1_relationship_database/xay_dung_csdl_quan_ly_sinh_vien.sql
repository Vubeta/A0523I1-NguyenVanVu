CREATE DATABASE `student-management`;
USE `student-management`;
CREATE TABLE student (
id INT PRIMARY KEY,
`name` VARCHAR(45),
age INT,
country VARCHAR(45)
);
CREATE TABLE class (
id INT PRIMARY KEY,
`name` VARCHAR(45)
);
CREATE TABLE teacher (
id INT PRIMARY KEY,
`name` VARCHAR(45),
age INT,
country VARCHAR(45)
);