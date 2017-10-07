import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HornetAssault {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<Long> beehives = Arrays.stream(read.readLine().split("\\s+")).map(Long::valueOf).collect(Collectors.toList());
        List<Long> hornets = Arrays.stream(read.readLine().split("\\s+")).map(Long::valueOf).collect(Collectors.toList());

        long hornetsPower = hornetsPower(hornets);
        for (int i = 0; i < hornets.size(); i++) {
            if (beehives.size() == 1) {
                break;
            }
            for (int j = 0; j < beehives.size(); j++) {
                if (hornetsPower > beehives.get(j)) {
                    beehives.remove(j);
                    j--;
                } else if (hornetsPower < beehives.get(j)) {
                    long temp = beehives.get(j) - hornetsPower;
                    beehives.set(j, temp);
                    hornetsPower -= hornets.remove(i);
                } else if (hornetsPower == beehives.get(j)) {
                    beehives.remove(j);
                    hornetsPower -= hornets.remove(i);
                    j--;
                }
            }
        }
        if (beehives.isEmpty()) {
            for (Long hornet : hornets) {
                System.out.printf("%d ", hornet);
            }
        } else {
            for (Long beehive : beehives) {
                System.out.printf("%d ", beehive);
            }
        }
    }

    private static long hornetsPower(List<Long> hornets) {
        long hornetsPower = 0;
        for (Long hornet : hornets) {
            hornetsPower += hornet;
        }
        return hornetsPower;
    }
}
