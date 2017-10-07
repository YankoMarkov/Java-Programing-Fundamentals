import java.util.Arrays;
import java.util.Scanner;

public class FoldAndSum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Integer[] arrays = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::valueOf).toArray(Integer[]::new);

        int[] firstArray = new int[arrays.length / 2];
        int[] secondArray = new int[arrays.length / 2];
        int[] sumArray = new int[arrays.length / 2];
        int secondIndex = arrays.length / 4;
        int firstIndex = secondIndex - 1;

        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = arrays[secondIndex];
            secondIndex++;
        }

        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = arrays[firstIndex];
            if (firstIndex == 0) {
                firstIndex = arrays.length;
            }
            firstIndex--;
        }

        for (int i = 0; i < sumArray.length; i++) {
            sumArray[i] = firstArray[i] + secondArray[i];
        }

        for (int num : sumArray) {
            System.out.printf("%d ", num);
        }
    }
}
