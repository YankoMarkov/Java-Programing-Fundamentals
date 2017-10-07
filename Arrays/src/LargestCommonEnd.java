import java.util.Scanner;

public class LargestCommonEnd {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstArray = scan.nextLine().split("\\s+");
        String[] secondArray = scan.nextLine().split("\\s+");
        int leftCount = 0;
        int rightCount = 0;
        int length = 0;

        if (firstArray.length >= secondArray.length) {
            length = firstArray.length - secondArray.length;
            for (int i = 0; i < secondArray.length; i++) {
                if (secondArray[i].equals(firstArray[i])) {
                    leftCount++;
                }
            }
            for (int i = secondArray.length - 1; i >= 0; i--) {
                if (secondArray[i].equals(firstArray[i + length])) {
                    rightCount++;
                }
            }
        } else {
            length = secondArray.length - firstArray.length;
            for (int i = 0; i < firstArray.length; i++) {
                if (firstArray[i].equals(secondArray[i])) {
                    leftCount++;
                }
            }
            for (int i = firstArray.length - 1; i >= 0; i--) {
                if (firstArray[i].equals(secondArray[i + length])) {
                    rightCount++;
                }
            }
        }
        if (leftCount >= rightCount) {
            System.out.println(leftCount);
        } else {
            System.out.println(rightCount);
        }
    }
}
