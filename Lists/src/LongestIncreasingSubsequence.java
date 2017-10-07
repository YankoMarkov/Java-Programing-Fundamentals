import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) < numbers.get(i + 1)) {
                result.add(numbers.get(i));
            }
        }
        if (numbers.get(numbers.size() - 1) > result.get(result.size() - 1)) {
            result.add(numbers.get(numbers.size() - 1));
        }
        for (int i = 1; i < result.size() - 1; i++) {
            if (result.get(i) < result.get(i - 1) || result.get(i) > result.get(i + 1)) {
                result.remove(i);
                i--;
            }
        }
        for (Integer integer : result) {
            System.out.printf("%d ", integer);
        }
    }
}
