import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputs = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        long sum = 0;
        long count = 0;
        for (int input : inputs) {
            sum += input;
            count++;
        }
        double average = (double) sum / count;
        Collections.sort(inputs);
        Collections.reverse(inputs);
        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i) > average) {
                result.add(inputs.get(i));
            }
            if (result.size() == 5) {
                break;
            }
        }
        if (result.isEmpty()) {
            System.out.println("No");
        } else {
            for (int i : result) {
                System.out.printf("%d ", i);
            }
        }
    }
}
