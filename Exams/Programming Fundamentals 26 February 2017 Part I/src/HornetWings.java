import java.util.Scanner;

public class HornetWings {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wingFlaps = Integer.valueOf(scan.nextLine());
        double distance = Double.valueOf(scan.nextLine());
        int endurance = Integer.valueOf(scan.nextLine());

        double totalDistance = (wingFlaps / 1000.0) * distance;
        int flyInSecond = wingFlaps / 100;
        int tomeForRest = (wingFlaps / endurance) * 5;
        int totalFlyInSeconds = flyInSecond + tomeForRest;

        System.out.printf("%.2f m.\n%d s.", totalDistance, totalFlyInSeconds);
    }
}
