import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxSequenceOfEqualElements {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        int count = 1;
        int index = 0;
        int bestCount = 0;
        int bestIndex = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0 || !numbers.get(i).equals(numbers.get(i - 1))) {
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
            System.out.printf("%d ", numbers.get(bestIndex));
        }
    }
}
