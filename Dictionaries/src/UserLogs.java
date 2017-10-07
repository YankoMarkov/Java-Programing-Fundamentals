import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();
        String inputs = null;

        while (!(inputs = scan.nextLine()).equals("end")) {
            Pattern pattern = Pattern.compile("IP=(?<IP>[\\d.]+|[\\w:]+)\\s+message='(?<message>.*)'\\s+user=(?<user>[a-zA-Z0-9]+)");
            Matcher matcher = pattern.matcher(inputs);

            while (matcher.find()) {
                String ip = matcher.group("IP");
                String user = matcher.group("user");

                if (!map.containsKey(user)) {
                    map.put(user, new LinkedHashMap<>());
                }
                if (!map.get(user).containsKey(ip)) {
                    map.get(user).put(ip, 1);
                } else {
                    map.get(user).put(ip, map.get(user).get(ip) + 1);
                }
            }
        }
        for (String users : map.keySet()) {
            System.out.printf("%s:%n", users);
            //String ipResult = "";
            List<String> temp = new ArrayList<>();
            for (String ip : map.get(users).keySet()) {
                //ipResult += String.format("%s => %d, ", ip, map.get(users).get(ip));
                temp.add(String.format("%s => %d", ip, map.get(users).get(ip)));
            }
            //ipResult = ipResult.substring(0, ipResult.length() - 2) + ".";
            //System.out.println(ipResult);
            System.out.println(String.join(", ", temp) + ".");
        }
    }
}
