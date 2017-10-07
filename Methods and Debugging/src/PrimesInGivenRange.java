import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimesInGivenRange {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int from = Integer.valueOf(scan.nextLine());
        int to = Integer.valueOf(scan.nextLine());

        System.out.print(String.join(", ", String.valueOf(primesInRange(from, to))).replaceAll("[\\[\\]]", ""));
    }

    private static List<Integer> primesInRange(int from, int to) {
        List<Integer> numbers = new ArrayList<>();
        for (int currentNum = from; currentNum <= to; currentNum++) {
            if (isPrime(currentNum)) {
                numbers.add(currentNum);
            }
        }
        return numbers;
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
