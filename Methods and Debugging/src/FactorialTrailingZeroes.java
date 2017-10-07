import java.math.BigInteger;
import java.util.Scanner;

public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.valueOf(scan.nextLine());

        System.out.println(countZeroInFactorial(factorial(num)));
    }

    private static BigInteger factorial(int num) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= num; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    private static int countZeroInFactorial(BigInteger num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        String result = sb.reverse().toString();
        int count = 0;
        int index = 0;

        while (result.charAt(index) == '0') {
            count++;
            index++;
        }
        return count;
    }
}
