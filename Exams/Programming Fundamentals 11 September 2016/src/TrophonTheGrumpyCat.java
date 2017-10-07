import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TrophonTheGrumpyCat {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> priceRatings = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf)
                .collect(Collectors.toList());
        int entryPoint = Integer.valueOf(read.readLine());
        String typeOfItems = read.readLine();
        String typeOfPriceRatings = read.readLine();

        List<Integer> left = priceRatings.subList(0, entryPoint);
        List<Integer> right = priceRatings.subList(entryPoint + 1, priceRatings.size());
        final int entryPrice = priceRatings.get(entryPoint);

        Predicate<Integer> keep = i -> i < entryPrice;
        if (typeOfItems.equals("expensive")) {
            keep = i -> i >= entryPrice;
        }
        left = left.stream().filter(keep).collect(Collectors.toList());
        right = right.stream().filter(keep).collect(Collectors.toList());
        keep = null;
        switch (typeOfPriceRatings) {
            case "positive":
                keep = i -> i > 0;
                break;
            case "negative":
                keep = i -> i < 0;
                break;
        }
        if (keep != null) {
            left = left.stream().filter(keep).collect(Collectors.toList());
            right = right.stream().filter(keep).collect(Collectors.toList());
        }
        long leftSum = left.stream().mapToLong(Integer::intValue).sum();
        long rightSum = right.stream().mapToLong(Integer::intValue).sum();

        if (leftSum >= rightSum) {
            System.out.printf("Left - %d%n", leftSum);
        } else {
            System.out.printf("Right - %d%n", rightSum);
        }
    }
}