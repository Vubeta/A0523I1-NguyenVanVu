CREATE DATABASE QuanLySinhVien;
USE QuanLySinhVien;
CREATE TABLE Class(
    ClassID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME    NOT NULL,
    `Status`    BIT
);
CREATE TABLE Student(
    StudentId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    `Status`      BIT,
    ClassId     INT         NOT NULL,
    FOREIGN KEY (ClassId) REFERENCES Class (ClassID)
);
CREATE TABLE `Subject`(
    SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    `Status`  BIT                  DEFAULT 1
);
CREATE TABLE Mark(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES `Subject` (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);
INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);

INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO `Subject`
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);

INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);

use QuanLySinhVien;
-- Ex1. Hien thi tat ca các sinh viên có tên bat đau bang ký tu ‘h’
select * from Student where StudentName like 'h%';

-- Ex2. Hien thi các thông tin lop hoc có thoi gian bat đau vào tháng 12
select * from class where month(StartDate) = 12;

-- Ex3. Hien thi tat ca các thông tin môn hoc có credit trong khoang tu 3-5
select * from `Subject` where Credit >=3 and Credit <=5;

-- Ex4. Thay đoi mã lop(ClassID) cua sinh viên có tên ‘Hung’ là 2.
-- method 1:
set sql_safe_updates = 0;
update Student set ClassId = 2 where StudentName = 'Hung';
set sql_safe_updates = 1;
select * from Student;
-- method 2:
-- set @student_ids = (select StudentId from Student where StudentName = 'Hung');
-- update Student set ClassId = 1 where udentId in (@student_ids);

-- Ex5. Hien thi các thông tin: StudentName, SubName, Mark. Du lieu sap xep theo điem thi (mark) giam dan. Neu trùng sap theo tên tăng dan.
select sm.StudentName, sm.Mark, `Subject`.SubName 
from (select Student.StudentName, Mark, SubId from Mark join Student on Mark.StudentId = Student.StudentId) as sm 
join `Subject` on sm.SubId = `Subject`.SubId
order by sm.Mark desc, sm.StudentName asc;