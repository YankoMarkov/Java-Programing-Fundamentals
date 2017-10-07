import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = read.readLine().split("[,\\s]+");
        Pattern pattern = Pattern.compile("(?<numbers>-?\\d+\\.\\d+|-?\\d+)|(?<exclusive>[-+.])|(?<multiply>[*])|(?<divide>[/])|(?<letters>[^\\d-+*/.])");
        Set<String> result = new TreeSet<>();

        for (String input : inputs) {
            Matcher matcher = pattern.matcher(input);
            StringBuilder multiply = new StringBuilder();
            StringBuilder divide = new StringBuilder();
            double damage = 0;
            int health = 0;

            while (matcher.find()) {
                String tempLetter = matcher.group("letters");
                if (tempLetter != null) {
                    char letter = tempLetter.charAt(0);
                    health += (int) letter;
                }
                String numbers = matcher.group("numbers");
                if (numbers != null) {
                    double number = Double.valueOf(numbers);
                    damage += number;
                }
                String tempMultiply = matcher.group("multiply");
                if (tempMultiply != null) {
                    multiply = multiply.append(tempMultiply);
                }
                String tempDivide = matcher.group("divide");
                if (tempDivide != null) {
                    divide = divide.append(tempDivide);
                }
            }

            for (int i = 0; i < multiply.length(); i++) {
                damage *= 2;
            }
            for (int i = 0; i < divide.length(); i++) {
                damage /= 2;
            }
            result.add(String.format("%s - %d health, %.2f damage", input, health, damage));
        }
        for (String s : result) {
            System.out.println(s);
        }
    }
}
