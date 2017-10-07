import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasterNumbers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.valueOf(scan.nextLine());

        List<String> isSymmetric = new ArrayList<>(isSymmetric(number));
        List<String> sumOfDigitsDivisibleBy7 = new ArrayList<>(sumOfDigitsIsDivisibleBy7(isSymmetric));
        List<String> isHoldsEvenDigit = new ArrayList<>(isHoldsLeastOneEvenDigit(sumOfDigitsDivisibleBy7));

        if (isHoldsEvenDigit.size() > 0) {
            for (String s : isHoldsEvenDigit) {
                System.out.println(s);
            }
        }
    }

    private static List<String> isSymmetric(int num) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String number = String.valueOf(i);
            if (number.length() % 2 == 0 && number.length() > 1) {
                String firstHalf = number.substring(0, number.length() / 2);
                StringBuilder sb = new StringBuilder(number.substring(number.length() / 2, number.length()));
                String secondHalf = sb.reverse().toString();
                if (firstHalf.equals(secondHalf)) {
                    result.add(number);
                }
            } else if (number.length() % 2 != 0 && number.length() > 1) {
                String firstHalf = number.substring(0, number.length() / 2);
                StringBuilder sb = new StringBuilder(number.substring((number.length() / 2) + 1, number.length()));
                String secondHalf = sb.reverse().toString();
                if (firstHalf.equals(secondHalf)) {
                    result.add(number);
                }
            }
        }
        return result;
    }

    private static List<String> sumOfDigitsIsDivisibleBy7(List<String> list) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            String res = list.get(i);
            for (int j = 0; j < res.length(); j++) {
                sum += (int) res.charAt(j) - 48;
            }
            if (sum % 7 == 0) {
                result.add(res);
            }
        }
        return result;
    }

    private static List<String> isHoldsLeastOneEvenDigit(List<String> list) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            String res = list.get(i);
            for (int j = 0; j < res.length(); j++) {
                int temp = (int) res.charAt(j) - 48;
                if (temp % 2 == 0) {
                    count++;
                }
            }
            if (count > 0) {
                result.add(res);
            }
        }
        return result;
    }
}
