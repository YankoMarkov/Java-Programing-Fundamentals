import java.util.Scanner;

public class GeometryCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String figure = scan.nextLine();
        double firstSide = 0;
        double secondSide = 0;

        switch (figure) {
            case "triangle":
                firstSide = Double.valueOf(scan.nextLine());
                secondSide = Double.valueOf(scan.nextLine());
                System.out.printf("%.2f", triangleArea(firstSide, secondSide));
                break;
            case "square":
                firstSide = Double.valueOf(scan.nextLine());
                System.out.printf("%.2f", squareArea(firstSide));
                break;
            case "rectangle":
                firstSide = Double.valueOf(scan.nextLine());
                secondSide = Double.valueOf(scan.nextLine());
                System.out.printf("%.2f", rectangleArea(firstSide, secondSide));
                break;
            case "circle":
                firstSide = Double.valueOf(scan.nextLine());
                System.out.printf("%.2f", circleArea(firstSide));
                break;
            default:
                break;
        }
    }

    private static double triangleArea(double side, double height) {
        return (side * height) / 2;
    }

    private static double squareArea(double side) {
        return side * side;
    }

    private static double rectangleArea(double width, double height) {
        return width * height;
    }

    private static double circleArea(double radius) {
        return Math.PI * (radius * radius);
    }
}
