import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharityMarathon {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        long daysOfMarathon = Long.valueOf(read.readLine());
        long numberOfRunners = Long.valueOf(read.readLine());
        long numbersOfAverageLaps = Long.valueOf(read.readLine());
        long lengthOfTrack = Long.valueOf(read.readLine());
        long trackCapacity = Long.valueOf(read.readLine());
        double moneyPerKilometers = Double.valueOf(read.readLine());

        long maxRunners = daysOfMarathon * trackCapacity;
        if (maxRunners > numberOfRunners) {
            maxRunners = numberOfRunners;
        }
        long totalMeters = maxRunners * numbersOfAverageLaps * lengthOfTrack;
        long totalKilometers = totalMeters / 1000;
        double moneyForMarathon = totalKilometers * moneyPerKilometers;

        System.out.printf("Money raised: %.2f", moneyForMarathon);
    }
}
