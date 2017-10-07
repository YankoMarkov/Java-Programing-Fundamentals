import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumReversedNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> reverseNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(numbers.get(i)));
            sb = sb.reverse();
            int number = Integer.valueOf(String.valueOf(sb));
            reverseNumbers.add(number);
        }
        int sum = 0;
        for (Integer reverseNumber : reverseNumbers) {
            sum += reverseNumber;
        }
        System.out.println(sum);
    }
}
