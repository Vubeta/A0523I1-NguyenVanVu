package ss5_access_modifier_and_static_method_and_static_property;

public class Student {
    private String name = "John";
    private String classes = "C02";

    Student() {
    }

    protected String setName(String name) {
        this.name = name;
        return this.name;
    }

    String setClasses(String classes) {
        this.classes = classes;
        return this.classes;
    }
}

class Test {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.setName("Vu"));
        System.out.println(student.setClasses("A05"));
    }
}
