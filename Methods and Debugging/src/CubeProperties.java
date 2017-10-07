import java.util.Scanner;

public class CubeProperties {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number = Double.valueOf(scan.nextLine());
        String command = scan.nextLine();

        switch (command) {
            case "face":
                System.out.printf("%.2f", getCubFace(number));
                break;
            case "space":
                System.out.printf("%.2f", getCubeSpace(number));
                break;
            case "volume":
                System.out.printf("%.2f", getCubeVolume(number));
                break;
            case "area":
                System.out.printf("%.2f", getCubeArea(number));
                break;
            default:
                break;
        }
    }

    private static double getCubFace(double num) {
        return Math.sqrt(2 * (num * num));
    }

    private static double getCubeSpace(double num) {
        return Math.sqrt(3 * (num * num));
    }

    private static double getCubeArea(double num) {
        return 6 * (num * num);
    }

    private static double getCubeVolume(double num) {
        return Math.pow(num, 3);
    }
}
