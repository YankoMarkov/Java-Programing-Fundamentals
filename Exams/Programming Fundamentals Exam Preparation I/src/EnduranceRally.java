import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnduranceRally {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] names = read.readLine().split("\\s+");
        List<Double> track = Arrays.stream(read.readLine().split("\\s+")).map(Double::valueOf).collect(Collectors.toList());
        List<Integer> checkpoint = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        for (String name : names) {
            double fuel = name.charAt(0);
            for (int i = 0; i < track.size(); i++) {
                if (checkpoint.contains(i)) {
                    fuel += track.get(i);
                } else {
                    fuel -= track.get(i);
                }
                if (fuel <= 0) {
                    System.out.printf("%s - reached %d\n", name, i);
                    break;
                }
            }
            if (fuel > 0) {
                System.out.printf("%s - fuel left %.2f\n", name, fuel);
            }
        }

    }
}
