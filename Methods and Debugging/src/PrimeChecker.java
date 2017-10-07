import java.util.Scanner;

public class PrimeChecker {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long num = Long.valueOf(scan.nextLine());

        if (isPrime(num)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static boolean isPrime(long a) {
        if (a == 0 || a == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
