import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FootballStandings {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> teamsGoalResult = new TreeMap<>();
        Map<String, Integer> teamsPointResult = new TreeMap<>();
        String key = read.readLine();
        String input = null;

        while (!(input = read.readLine()).equals("final")) {
            if (key.contains("?")) {
                key = key.replace("?", "X");
            }
            input = input.replaceAll("\\?", "X");
            Pattern pattern = Pattern.compile("(" + key + ")(?<team>[a-zA-Z]*)(" + key + ")|(?<result>\\d+:\\d+)");
            Matcher matcher = pattern.matcher(input);
            StringBuilder temp = new StringBuilder();
            String firstTeam = "";
            String secondTeam = "";
            int firstResult = 0;
            int secondResult = 0;

            while (matcher.find()) {
                if (matcher.group("team") != null) {
                    if (firstTeam.isEmpty()) {
                        temp.delete(0, temp.length());
                        firstTeam = matcher.group("team");
                        temp = temp.append(firstTeam).reverse();
                        firstTeam = temp.toString().toUpperCase();
                        if (firstTeam.isEmpty()) {
                            firstTeam = " ";
                        }
                        continue;
                    }
                    if (secondTeam.isEmpty()) {
                        temp.delete(0, temp.length());
                        secondTeam = matcher.group("team");
                        temp = temp.append(secondTeam).reverse();
                        secondTeam = temp.toString().toUpperCase();
                        if (firstTeam.equals(" ")) {
                            firstTeam = "";
                        }
                    }
                }
                if (matcher.group("result") != null) {
                    String[] result = matcher.group("result").split(":");
                    firstResult = Integer.valueOf(result[0]);
                    secondResult = Integer.valueOf(result[1]);
                }
            }
            if (!teamsGoalResult.containsKey(firstTeam)) {
                teamsGoalResult.put(firstTeam, firstResult);
            } else {
                teamsGoalResult.put(firstTeam, teamsGoalResult.get(firstTeam) + firstResult);
            }
            if (!teamsGoalResult.containsKey(secondTeam)) {
                teamsGoalResult.put(secondTeam, secondResult);
            } else {
                teamsGoalResult.put(secondTeam, teamsGoalResult.get(secondTeam) + secondResult);
            }
            if (firstResult > secondResult) {
                if (!teamsPointResult.containsKey(firstTeam)) {
                    teamsPointResult.put(firstTeam, 3);
                } else {
                    teamsPointResult.put(firstTeam, teamsPointResult.get(firstTeam) + 3);
                }
                if (!teamsPointResult.containsKey(secondTeam)) {
                    teamsPointResult.put(secondTeam, 0);
                }
                continue;
            }
            if (firstResult < secondResult) {
                if (!teamsPointResult.containsKey(secondTeam)) {
                    teamsPointResult.put(secondTeam, 3);
                } else {
                    teamsPointResult.put(secondTeam, teamsPointResult.get(secondTeam) + 3);
                }
                if (!teamsPointResult.containsKey(firstTeam)) {
                    teamsPointResult.put(firstTeam, 0);
                }
                continue;
            }
            if (firstResult == secondResult) {
                if (!teamsPointResult.containsKey(firstTeam)) {
                    teamsPointResult.put(firstTeam, 1);
                } else {
                    teamsPointResult.put(firstTeam, teamsPointResult.get(firstTeam) + 1);
                }
                if (!teamsPointResult.containsKey(secondTeam)) {
                    teamsPointResult.put(secondTeam, 1);
                } else {
                    teamsPointResult.put(secondTeam, teamsPointResult.get(secondTeam) + 1);
                }
            }
        }

        final int[] placePoint = {0};
        System.out.println("League standings:");
        teamsPointResult.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(result -> {
                    placePoint[0]++;
                    System.out.printf("%s. %s %s\n", placePoint[0], result.getKey(), result.getValue());
                });

        final int[] count = {0};
        System.out.println("Top 3 scored goals:");
        teamsGoalResult.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(result -> {
                    count[0]++;
                    if (count[0] < 4) {
                        System.out.printf("- %s -> %s\n", result.getKey(), result.getValue());
                    }
                });
    }
}
