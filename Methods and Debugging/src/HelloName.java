import java.util.Scanner;

public class HelloName {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        printName(input);

    }

    private static void printName(String name) {
        System.out.printf("Hello, %s!", name);
    }
}
