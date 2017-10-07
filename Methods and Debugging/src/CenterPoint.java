import java.text.DecimalFormat;
        import java.util.Scanner;

public class CenterPoint {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.valueOf(scan.nextLine());
        double y1 = Double.valueOf(scan.nextLine());
        double x2 = Double.valueOf(scan.nextLine());
        double y2 = Double.valueOf(scan.nextLine());

        closerPointDistance(x1, y1, x2, y2);
    }

    private static void closerPointDistance(double x1, double y1, double x2, double y2) {
        double x = 0;
        double y = 0;
        if (x2 * x2 + y2 * y2 >= x1 * x1 + y1 * y1) {
            x = x1;
            y = y1;
        } else {
            x = x2;
            y = y2;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.printf("(%s, %s)", df.format(x), df.format(y));
    }
}
