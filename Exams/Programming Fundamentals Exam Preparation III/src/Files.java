import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Files {

    private static boolean hasResult;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(read.readLine());
        Map<String, Map<String, Long>> result = new HashMap<>();

        for (int i = 0; i < num; i++) {
            String[] inputs = read.readLine().split("[\\\\\\s]+");
            String root = inputs[0];
            if (!result.containsKey(root)) {
                result.put(root, new HashMap<>());
            }
            String[] temp = inputs[inputs.length - 1].split(";");
            String fileName = temp[0];
            long fileSize = Long.valueOf(temp[1]);
            result.get(root).put(fileName, fileSize);
        }
        String[] command = read.readLine().trim().split("\\s+");

        hasResult = false;
        result.entrySet().stream()
                .filter(s -> s.getKey().endsWith(command[2]))
                .forEach(file ->
                        file.getValue().entrySet().stream()
                                .sorted((a1, a2) -> {
                                    long first = a1.getValue();
                                    long second = a2.getValue();
                                    if (first == second) {
                                        return a1.getKey().compareTo(a2.getKey());
                                    }
                                    return Long.compare(a2.getValue(), a1.getValue());
                                })
                                .filter(s -> s.getKey().endsWith(command[0]))
                                .forEach(s -> {
                                    System.out.printf("%s - %s KB\n", s.getKey(), s.getValue());
                                    hasResult = true;
                                }));
        if (!hasResult) {
            System.out.println("No");
        }
    }
}
