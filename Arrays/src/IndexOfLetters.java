import java.util.Scanner;

public class IndexOfLetters {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            int b = input.charAt(i) - 97;
            System.out.printf("%s -> %d\n", a, b);
        }
    }
}
