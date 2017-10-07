import java.util.Scanner;

public class FibonacciNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.valueOf(scan.nextLine());

        System.out.println(fibonacciLoop(num));
        System.out.println(fibonacciRecursion(num));
    }

    private static long fibonacciRecursion(int a) {
        if (a == 0 || a == 1) {
            return 1;
        }
        return fibonacciRecursion(a - 1) + fibonacciRecursion(a - 2);
    }

    private static long fibonacciLoop(int a) {
        long fibonacci = 1;
        long fib1 = 1;
        long fib2 = 1;

        for (int i = 2; i <= a; i++) {
            fibonacci = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibonacci;
        }
        return fibonacci;
    }
}
