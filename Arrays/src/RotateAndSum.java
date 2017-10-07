import java.util.Arrays;
import java.util.Scanner;

public class RotateAndSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] arrays = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::valueOf).toArray(Integer[]::new);
        int number = Integer.valueOf(scan.nextLine());

        int[] sumArray = new int[arrays.length];
        int[] tempArray = new int[arrays.length];

        for (int i = 0; i < number; i++) {
            for (int j = 1; j <= arrays.length; j++) {
                tempArray[j % tempArray.length] = arrays[j - 1];
            }
            for (int j = 0; j < sumArray.length; j++) {
                sumArray[j] += tempArray[j];
                arrays[j] = tempArray[j];
            }
        }

        for (int num : sumArray) {
            System.out.printf("%d ",num);
        }
    }
}
