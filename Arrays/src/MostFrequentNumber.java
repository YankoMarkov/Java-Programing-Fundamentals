import java.util.Arrays;
import java.util.Scanner;

public class MostFrequentNumber {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arrays = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        int mostFrequentNumber = 0;
        int bestCount = 0;

        for (int i = 0; i < arrays.length; i++) {
            int count = 0;
            for (int j = i; j < arrays.length; j++) {
                if (arrays[j] == arrays[i]) {
                    count++;
                }
            }
            if (count > bestCount) {
                bestCount = count;
                mostFrequentNumber = arrays[i];
            }
        }
        System.out.println(mostFrequentNumber);
    }
}
