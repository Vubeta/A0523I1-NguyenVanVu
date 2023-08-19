package ss5_access_modifier_and_static_method_and_static_property;

public class TestStaticMethod {
    static class Student {
        private int rollno;
        private String name;
        private String college = "BBDIT";

        //constructor to initialize the variable
        Student(int r, String n) {
            rollno = r;
            name = n;
        }

        //static method to change the value of static variable
        void change() {
            college = "CODEGYM";
        }

        //method to display values
        void display() {
            System.out.println(rollno + " " + name + " " + college);
        }
    }

    public static void main(String args[]) {
//        Student.change(); //calling change method

        //creating objects
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");

        //calling display method
        s1.change();
        s2.change();
        s3.change();
        s1.display();
        s2.display();
        s3.display();
    }
}