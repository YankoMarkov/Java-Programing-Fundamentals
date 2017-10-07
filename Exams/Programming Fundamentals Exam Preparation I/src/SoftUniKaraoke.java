import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SoftUniKaraoke {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<String> participants = Arrays.stream(read.readLine().split(",\\s+")).map(String::valueOf).collect(Collectors.toList());
        List<String> songs = Arrays.stream(read.readLine().split(",\\s+")).map(String::valueOf).collect(Collectors.toList());
        Map<String, List<String>> results = new TreeMap<>();
        String inputs = null;

        String participant = "";
        String song = "";
        String award = "";

        while (!(inputs = read.readLine()).equals("dawn")) {
            String[] input = inputs.split(",\\s");
            participant = input[0];
            song = input[1];
            award = input[2];

            if (participants.contains(participant) && songs.contains(song)) {
                if (!results.containsKey(participant)) {
                    results.put(participant, new ArrayList<>());
                }
                if (!results.get(participant).contains(award)) {
                    results.get(participant).add(award);
                }
            }
        }
        if (results.isEmpty()) {
            System.out.println("No awards");
        } else {
            results.entrySet().stream()
                    .sorted((a1, a2) ->
                            Integer.compare(a2.getValue().size(), a1.getValue().size()))
                    .forEach(result -> {
                        System.out.printf("%s: %d awards\n", result.getKey(), result.getValue().size());
                        Collections.sort(result.getValue());
                        for (String s : result.getValue()) {
                            System.out.printf("--%s\n", s);
                        }
                    });
        }
    }
}
