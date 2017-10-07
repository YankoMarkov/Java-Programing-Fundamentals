import java.util.Arrays;
import java.util.Scanner;

public class CompareCharArrays {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] first = scan.nextLine().split("\\s+");
        String[] second = scan.nextLine().split("\\s+");
        char[] firstChar = new char[first.length];
        char[] secondChar = new char[second.length];

        if (first.length < second.length) {
            System.out.println(Arrays.toString(first).replaceAll("[\\[\\],\\s]", ""));
            System.out.println(Arrays.toString(second).replaceAll("[\\[\\],\\s]", ""));
        } else if (first.length > second.length) {
            System.out.println(Arrays.toString(second).replaceAll("[\\[\\],\\s]", ""));
            System.out.println(Arrays.toString(first).replaceAll("[\\[\\],\\s]", ""));
        } else if (first.length == second.length) {
            for (int i = 0; i < first.length; i++) {
                firstChar[i] = first[i].charAt(i);
                secondChar[i] = second[i].charAt(i);
                if (firstChar[i] <= secondChar[i]) {
                    System.out.println(Arrays.toString(first).replaceAll("[\\[\\],\\s]", ""));
                    System.out.println(Arrays.toString(second).replaceAll("[\\[\\],\\s]", ""));
                    break;
                } else if (secondChar[i] < firstChar[i]) {
                    System.out.println(Arrays.toString(second).replaceAll("[\\[\\],\\s]", ""));
                    System.out.println(Arrays.toString(first).replaceAll("[\\[\\],\\s]", ""));
                    break;
                }
            }
        }
    }
}
