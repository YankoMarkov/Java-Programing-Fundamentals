import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = read.readLine().split("[,\\s]+");
        Pattern pattern = Pattern.compile("(?<a>#{6,10})|(?<b>@{6,10})|(?<c>\\${6,10})|(?<d>\\^{6,10})");

        for (String in : inputs) {
            if (in.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }
            String first = in.substring(0, 10);
            String second = in.substring(10, 20);
            char groupChar = ' ';
            int firstLength = 0;
            int secondLength = 0;

            Matcher matcher = pattern.matcher(first);
            while (matcher.find()) {
                String match = matcher.group("a");
                if (match != null) {
                    groupChar = '#';
                    firstLength = match.length();
                    break;
                }
                match = matcher.group("b");
                if (match != null) {
                    groupChar = '@';
                    firstLength = match.length();
                    break;
                }
                match = matcher.group("c");
                if (match != null) {
                    groupChar = '$';
                    firstLength = match.length();
                    break;
                }
                match = matcher.group("d");
                if (match != null) {
                    groupChar = '^';
                    firstLength = match.length();
                    break;
                }
            }
            if (firstLength < 6) {
                System.out.printf("ticket \"%s\" - no match\n", in);
                continue;
            }

            matcher = pattern.matcher(second);
            if (!matcher.find()) {
                System.out.printf("ticket \"%s\" - no match\n", in);
                continue;
            }
            switch (groupChar) {
                case '#':
                    if (matcher.group("a") != null) {
                        secondLength = matcher.group("a").length();
                    }
                case '@':
                    if (matcher.group("b") != null) {
                        secondLength = matcher.group("b").length();
                    }
                case '$':
                    if (matcher.group("c") != null) {
                        secondLength = matcher.group("c").length();
                    }
                case '^':
                    if (matcher.group("d") != null) {
                        secondLength = matcher.group("d").length();
                    }
            }

            if (secondLength < 6) {
                System.out.printf("ticket \"%s\" - no match\n", in);
                continue;
            }

            if (firstLength == 10 && secondLength == 10) {
                System.out.printf("ticket \"%s\" - %s%s Jackpot!\n", in, firstLength, groupChar);
                continue;
            }

            int matchLength = Math.min(firstLength, secondLength);
            System.out.printf("ticket \"%s\" - %s%s\n", in, matchLength, groupChar);
        }
    }
}
