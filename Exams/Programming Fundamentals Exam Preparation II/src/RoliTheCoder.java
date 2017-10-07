import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RoliTheCoder {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> idToName = new HashMap<>();
        Map<String, Set<String>> result = new HashMap<>();
        String inputs;

        while (!(inputs = read.readLine().trim()).equals("Time for Code")) {
            String[] input = inputs.split("\\s+");
            if (input.length < 2 || !input[1].startsWith("#")) {
                continue;
            }
            int id = Integer.valueOf(input[0]);
            String eventName = input[1].substring(1);
            Set<String> participants;
            if (idToName.containsKey(id)) {
                if (!eventName.equals(idToName.get(id))) {
                    continue;
                } else {
                    participants = result.get(eventName);
                }
            } else {
                idToName.put(id, eventName);
                participants = new HashSet<>();
                result.put(eventName, participants);
            }

            for (int i = 2; i < input.length; i++) {
                if (input[i].startsWith("@")) {
                    participants.add(input[i]);
                }
            }
        }

        result.entrySet().stream()
                .sorted((e1, e2) -> {
                    if (e1.getValue().size() == e2.getValue().size()) {
                        return e1.getKey().compareToIgnoreCase(e2.getKey());
                    }
                    return Integer.compare(e2.getValue().size(), e1.getValue().size());
                }).forEach(name -> {
            System.out.printf("%s - %d\n", name.getKey(), name.getValue().size());
            name.getValue().stream()
                    .sorted(String::compareToIgnoreCase)
                    .forEach(System.out::println);
        });
    }
}
