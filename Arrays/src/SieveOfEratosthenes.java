import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.valueOf(scan.nextLine());

        boolean[] isPrime = new boolean[number + 1];

        for (int i = 2; i <= number; i++) {
            if (!isPrime[i]) {
                System.out.print(i + " ");
                for (int j = i; j <= number; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }
}
