import java.util.Scanner;

public class EnglishNameOfLastDigit {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long num = Long.valueOf(scan.nextLine());

        System.out.println(lastDigitName(num));
    }

    private static String lastDigitName(long a) {
        long number = Math.abs(a) % 10;
        int num = (int) number;
        String result = "";
        switch (num) {
            case 0:
                result = "zero";
                break;
            case 1:
                result = "one";
                break;
            case 2:
                result = "two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
                result = "four";
                break;
            case 5:
                result = "five";
                break;
            case 6:
                result = "six";
                break;
            case 7:
                result = "seven";
                break;
            case 8:
                result = "eight";
                break;
            case 9:
                result = "nine";
                break;
            default:
                break;
        }
        return result;
    }
}
