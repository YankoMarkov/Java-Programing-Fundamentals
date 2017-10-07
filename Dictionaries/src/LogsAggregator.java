import java.util.*;

public class LogsAggregator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        Map<String, TreeSet<String>> users = new TreeMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String ip = input[0];
            String user = input[1];
            int duration = Integer.valueOf(input[2]);

            if (!users.containsKey(user)) {
                users.put(user, new TreeSet<>());
                count.put(user, 0);
            }
            count.put(user, count.get(user) + duration);
            users.get(user).add(ip);
        }
        for (String user : users.keySet()) {
            System.out.printf("%s: %d ", user, count.get(user));
            String temp = "";
            for (String ip : users.get(user)) {
                temp += String.format("%s, ", ip);
            }
            temp = temp.substring(0, temp.length() - 2);
            System.out.println("[" + temp + "]");
        }
    }
}
