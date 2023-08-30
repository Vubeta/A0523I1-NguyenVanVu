package ss6_inheritance;

public class Test {
    static public class B {
    }

    public class C {
    }
}

class runTest {
    public static void main(String[] args) {
//        Test.C o = new Test().new C();
        Test.B o = new Test.B();
    }
}