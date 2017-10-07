import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SplinterTrip {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        double distance = Double.valueOf(read.readLine());
        double fuel = Double.valueOf(read.readLine());
        double heavyWindsMiles = Double.valueOf(read.readLine());

        double nonHeavyWindsMiles = distance - heavyWindsMiles;
        double nonHeavyWindsConsumption = nonHeavyWindsMiles * 25.0;
        double heavyWindsConsumption = heavyWindsMiles * (25.0 * 1.5);
        double fuelConsumption = heavyWindsConsumption + nonHeavyWindsConsumption;
        double fuelNeeded = fuelConsumption + (fuelConsumption * 0.05);
        double remainingFuel = fuel - fuelNeeded;

        if (remainingFuel >= 0) {
            System.out.printf("Fuel needed: %.2fL\nEnough with %.2fL to spare!\n", fuelNeeded, remainingFuel);
        } else {
            double moreFuelNeed = fuelNeeded - fuel;
            System.out.printf("Fuel needed: %.2fL\nWe need %.2fL more fuel.\n", fuelNeeded, moreFuelNeed);
        }
    }
}
