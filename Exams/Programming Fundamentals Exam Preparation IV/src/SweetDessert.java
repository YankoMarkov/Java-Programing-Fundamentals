import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SweetDessert {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        double cashMoney = Double.valueOf(read.readLine());
        int guestNumber = Integer.valueOf(read.readLine());
        double bananasPrice = Double.valueOf(read.readLine());
        double eggsPrice = Double.valueOf(read.readLine());
        double berriesPrice = Double.valueOf(read.readLine());

        double sets = Math.ceil(guestNumber / 6.0);
        double totalSum = sets * (2.0 * bananasPrice) + sets * (4.0 * eggsPrice) + sets * (0.2 * berriesPrice);

        if (totalSum <= cashMoney) {
            System.out.printf("Ivancho has enough money - it would cost %.2flv.", totalSum);
        } else {
            double sum = totalSum - cashMoney;
            System.out.printf("Ivancho will have to withdraw money - he will need %.2flv more.", sum);
        }
    }
}
