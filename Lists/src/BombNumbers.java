import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> command = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        int bombIndex = command.get(0);
        int radiosBomb = command.get(1);
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(bombIndex)) {
                index = i;
                leftIndex = index - radiosBomb;
                rightIndex = index + radiosBomb;
                if (leftIndex < 0) {
                    leftIndex = 0;
                }
                if (rightIndex > numbers.size() - 1) {
                    rightIndex = numbers.size() - 1;
                }
                numbers.subList(leftIndex, rightIndex + 1).clear();
                i = -1;
            }
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}
