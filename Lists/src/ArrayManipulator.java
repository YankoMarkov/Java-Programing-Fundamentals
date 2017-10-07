import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayManipulator {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        String inputs = null;

        while (!(inputs = read.readLine()).equals("print")) {
            List<Integer> temporary = new ArrayList<>();
            String[] input = inputs.split("\\s+");
            String command = input[0];
            int index = 0;
            int number = 0;

            switch (command) {
                case "add":
                    index = Integer.valueOf(input[1]);
                    number = Integer.valueOf(input[2]);
                    numbers.add(index, number);
                    break;
                case "addMany":
                    number = Integer.valueOf(input[1]);
                    for (int i = 2; i < input.length; i++) {
                        temporary.add(Integer.valueOf(input[i]));
                    }
                    numbers.addAll(number, temporary);
                    break;
                case "contains":
                    number = Integer.valueOf(input[1]);
                    System.out.println(numbers.indexOf(number));
                    break;
                case "remove":
                    number = Integer.valueOf(input[1]);
                    numbers.remove(number);
                    break;
                case "shift":
                    index = Integer.valueOf(input[1]) % numbers.size();
                    for (int i = 0; i < index; i++) {
                        numbers.add(numbers.get(0));
                        numbers.remove(0);
                    }
                    break;
                case "sumPairs":
                    for (int i = 0; i < numbers.size(); i += 2) {
                        int currentElement = numbers.get(i);
                        int nextElement = 0;
                        if (i < numbers.size() - 1) {
                            nextElement = numbers.get(i + 1);
                        }
                        int sumPair = currentElement + nextElement;
                        temporary.add(sumPair);
                    }
                    numbers = temporary;
                    break;
                default:
                    break;
            }
        }
        System.out.println(numbers);
    }
}
