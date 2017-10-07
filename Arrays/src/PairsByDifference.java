import java.util.Arrays;
import java.util.Scanner;

public class PairsByDifference {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arrays = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int number = Integer.valueOf(scan.nextLine());
        int count = 0;

        for (int i = 0; i < arrays.length; i++) {
            for (int j = i; j < arrays.length; j++) {
                if (Math.abs(arrays[i] - arrays[j]) == number) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
