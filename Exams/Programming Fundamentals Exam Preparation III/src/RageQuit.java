import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String inputs = read.readLine();
        StringBuilder str = new StringBuilder();
        Set<Character> set = new HashSet<>();

        Pattern pattern = Pattern.compile("(?<numbers>\\d+)|(?<symbols>[^\\d]+)");
        Matcher matcher = pattern.matcher(inputs);
        String symbols = "";

        while (matcher.find()) {
            int number = 0;
            String temp = matcher.group("symbols");
            if (temp != null) {
                symbols = temp.toUpperCase();
            }
            String temp1 = matcher.group("numbers");
            if (temp1 != null) {
                number = Integer.valueOf(temp1);
                for (int i = 0; i < number; i++) {
                    str = str.append(symbols);
                }
                symbols = "";
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            set.add(temp);
        }
        System.out.printf("Unique symbols used: %d\n", set.size());
        System.out.println(str);
    }
}
