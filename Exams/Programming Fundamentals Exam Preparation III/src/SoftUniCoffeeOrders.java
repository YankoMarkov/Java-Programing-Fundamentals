import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SoftUniCoffeeOrders {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(read.readLine());
        BigDecimal totals = new BigDecimal("0");

        for (int i = 0; i < n; i++) {
            BigDecimal capsulePrice = new BigDecimal(read.readLine());
            String[] dates = read.readLine().split("/");
            BigDecimal capsuleCount = new BigDecimal(read.readLine());

            int years = Integer.valueOf(dates[2]);
            int months = Integer.valueOf(dates[1]);
            int days = Integer.valueOf(dates[0]);

            LocalDate date = LocalDate.of(years, months, days);
            int dayss = date.lengthOfMonth();
            BigDecimal daysOfMonth = new BigDecimal(dayss);

            BigDecimal total = new BigDecimal("0");
            total = daysOfMonth.multiply(capsulePrice).multiply(capsuleCount);
            totals = totals.add(total);
            System.out.printf("The price for the coffee is: $%.2f\n", total);
        }
        System.out.printf("Total: $%.2f", totals);
    }
}
