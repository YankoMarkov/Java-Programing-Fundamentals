import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SinoTheWalker {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String[] time = read.readLine().split(":");
        int hours = Integer.valueOf(time[0]) * 3600;
        int minutes = Integer.valueOf(time[1]) * 60;
        int seconds = Integer.valueOf(time[2]);
        int totalTime = hours + minutes + seconds;

        BigInteger totalTimes = BigInteger.valueOf(totalTime);

        BigInteger steps = new BigInteger(read.readLine());
        BigInteger secondPerSteps = new BigInteger(read.readLine());

        BigInteger totalTimeInSeconds = totalTimes.add(steps.multiply(secondPerSteps));
        BigInteger arrivalHours = totalTimeInSeconds.divide(BigInteger.valueOf(3600)).remainder(BigInteger.valueOf(24));
        BigInteger arrivalMinutes = totalTimeInSeconds.divide(BigInteger.valueOf(60)).remainder(BigInteger.valueOf(60));
        BigInteger arrivalSeconds = totalTimeInSeconds.remainder(BigInteger.valueOf(60));

        System.out.printf("Time Arrival: %02d:%02d:%02d", arrivalHours, arrivalMinutes, arrivalSeconds);
    }
}
