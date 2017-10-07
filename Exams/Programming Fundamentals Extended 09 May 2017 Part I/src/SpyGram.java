import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpyGram {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String privateKey = read.readLine();
        List<String> results = new ArrayList<>();
        Pattern pattern = Pattern.compile("TO:\\s[A-Z]*;\\sMESSAGE:\\s.*;");
        String inputs = null;

        while (!(inputs = read.readLine()).equals("END")) {
            Matcher matcher = pattern.matcher(inputs);

            while (matcher.find()) {
                if (matcher.group() != null) {
                    results.add(matcher.group());
                }
            }
        }
        Collections.sort(results);
        for (int i = 0; i < results.size(); i++) {
            int index = 0;
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < results.get(i).length(); j++) {
                if (index >= privateKey.length()) {
                    index = 0;
                }
                int num = privateKey.charAt(index) - 48;
                char temp = (char) (results.get(i).charAt(j) + num);
                result = result.append(temp);
                index++;
            }
            System.out.println(result);
        }
    }
}


