import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfIncreasingElements {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arrays = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int count = 1;
        int index = 0;
        int bestCount = 0;
        int bestIndex = 0;

        for (int i = 0; i < arrays.length; i++) {
            if (i == 0 || arrays[i] > arrays[i - 1]) {
                count = 1;
                index = i;
            } else {
                count++;
            }
            if (count > bestCount) {
                bestCount = count;
                bestIndex = index;
            }
        }
        for (int i = bestIndex; i < bestIndex + bestCount; i++) {
            System.out.printf("%d ", arrays[i]);
        }
    }
}
