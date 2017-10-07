import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HornetArmada {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(read.readLine());
        Map<String, Map<String, Integer>> legionsWithSoldiers = new LinkedHashMap<>();
        Map<String, Integer> legionsWithActivity = new LinkedHashMap<>();
        Map<String, Integer> sort = new HashMap<>();

        Pattern pattern = Pattern.compile("(?<activity>\\d+)\\s+=\\s+(?<legion>[^=->:\\s]+)\\s+->\\s+(?<soldier>[^=->:\\s]+):(?<count>\\d+)");

        for (int i = 0; i < n; i++) {
            String inputs = read.readLine();
            Matcher matcher = pattern.matcher(inputs);
            while (matcher.find()) {
                int activity = Integer.valueOf(matcher.group("activity"));
                String legion = matcher.group("legion");
                String soldier = matcher.group("soldier");
                int count = Integer.valueOf(matcher.group("count"));

                if (!legionsWithActivity.containsKey(legion)) {
                    legionsWithSoldiers.put(legion, new LinkedHashMap<>());
                    legionsWithActivity.put(legion, activity);
                }
                if (activity > legionsWithActivity.get(legion)) {
                    legionsWithActivity.put(legion, activity);
                }
                if (!legionsWithSoldiers.get(legion).containsKey(soldier)) {
                    legionsWithSoldiers.get(legion).put(soldier, count);
                    sort.put(legion, count);
                } else {
                    legionsWithSoldiers.get(legion).put(soldier, count + legionsWithSoldiers.get(legion).get(soldier));
                    sort.put(legion, sort.get(legion) + count);
                }
            }
        }

        String[] command = read.readLine().split("\\\\");
        if (command.length > 1) {
            int activities = Integer.valueOf(command[0]);
            String soldiers = command[1];

            legionsWithSoldiers.entrySet().stream()
                    .filter(s -> legionsWithActivity.get(s.getKey()) < activities)
                    .sorted((a1, a2) -> sort.get(a2.getKey()).compareTo(sort.get(a1.getKey())))
                    .forEach(legion -> {
                        System.out.printf("%s -> ", legion.getKey());
                        legion.getValue().entrySet().stream()
                                .filter(s -> s.getKey().equals(soldiers))
                                .forEach(soldier ->
                                        System.out.printf("%d\n", soldier.getValue()));
                    });

        } else {
            legionsWithActivity.entrySet().stream()
                    .sorted((activity1, activity2) -> activity2.getValue().compareTo(activity1.getValue()))
                    .forEach(legion ->
                            System.out.printf("%d : %s\n", legion.getValue(), legion.getKey()));
        }
    }
}

