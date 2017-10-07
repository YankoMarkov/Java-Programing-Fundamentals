import java.util.Scanner;

public class MaxMethod {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = Integer.valueOf(scan.nextLine());
        int num2 = Integer.valueOf(scan.nextLine());
        int num3 = Integer.valueOf(scan.nextLine());

        System.out.println(Math.max(num1, mathMin(num2, num3)));
    }

    private static int mathMin(int a, int b) {
        return Math.max(a, b);
    }
}
