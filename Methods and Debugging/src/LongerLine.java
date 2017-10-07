import java.text.DecimalFormat;
import java.util.Scanner;

public class LongerLine {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.valueOf(scan.nextLine());
        double y1 = Double.valueOf(scan.nextLine());
        double x2 = Double.valueOf(scan.nextLine());
        double y2 = Double.valueOf(scan.nextLine());
        double x3 = Double.valueOf(scan.nextLine());
        double y3 = Double.valueOf(scan.nextLine());
        double x4 = Double.valueOf(scan.nextLine());
        double y4 = Double.valueOf(scan.nextLine());

        printLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    private static double lineLength(double x1, double y1, double x2, double y2) {
        double x = Math.abs(x2 - x1);
        double y = Math.abs(y2 - y1);
        return Math.sqrt(x * x + y * y);
    }

    private static double distantToCenter(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    private static void printCloserPoint(double x1, double y1, double x2, double y2) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (distantToCenter(x1, y1) <= distantToCenter(x2, y2)) {
            System.out.printf("(%s, %s)(%s, %s)\n", df.format(x1), df.format(y1), df.format(x2), df.format(y2));
        } else {
            System.out.printf("(%s, %s)(%s, %s)\n", df.format(x2), df.format(y2), df.format(x1), df.format(y1));
        }
    }

    private static void printLongerLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        if (lineLength(x1, y1, x2, y2) >= lineLength(x3, y3, x4, y4)) {
            printCloserPoint(x1, y1, x2, y2);
        } else {
            printCloserPoint(x3, y3, x4, y4);
        }
    }
}
