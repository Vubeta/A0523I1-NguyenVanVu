package ss2_loop_in_java;

public class HienThiCacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        System.out.println("The prime numbers are less than 100 include: ");
        int integerNum = 0;
        do {
            if(checkPrimeNum(integerNum)) {
                System.out.print(integerNum + " ");
            }
            integerNum++;
        } while (integerNum<100);
    }
    public static boolean checkPrimeNum(int number) {
        if (number<2) {
            return false;
        }
        for (int i=2; i<=Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
