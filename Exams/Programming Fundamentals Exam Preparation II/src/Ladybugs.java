import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ladybugs {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int fieldSize = Integer.valueOf(read.readLine());
        int[] indexOfLadybugs = Arrays.stream(read.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int[] ladybugsField = new int[fieldSize];
        for (int indexOfLadybug : indexOfLadybugs) {
            for (int j = 0; j < ladybugsField.length; j++) {
                if (indexOfLadybug == j) {
                    ladybugsField[j] = 1;
                }
            }
        }
        String inputs = null;

        while (!(inputs = read.readLine()).equals("end")) {
            String[] input = inputs.split("\\s+");
            int fromIndex = Integer.valueOf(input[0]);
            String moveCommand = input[1];
            int toIndex = Integer.valueOf(input[2]);

            switch (moveCommand) {
                case "right":
                    for (int i = 0; i < ladybugsField.length; i++) {
                        if (i == fromIndex && ladybugsField[i] == 1) {
                            ladybugsField[i] = 0;
                            while (i + toIndex <= ladybugsField.length - 1 && i + toIndex >= 0) {
                                if (ladybugsField[i + toIndex] == 0) {
                                    ladybugsField[i + toIndex] = 1;
                                    break;
                                } else {
                                    i += toIndex;
                                }
                            }
                        }
                    }
                    break;
                case "left":
                    for (int i = 0; i < ladybugsField.length; i++) {
                        if (i == fromIndex && ladybugsField[i] == 1) {
                            ladybugsField[i] = 0;
                            while (i - toIndex <= ladybugsField.length - 1 && i - toIndex >= 0) {
                                if (ladybugsField[i - toIndex] == 0) {
                                    ladybugsField[i - toIndex] = 1;
                                    break;
                                } else {
                                    i -= toIndex;
                                }
                            }
                        }
                    }
                    break;
            }
        }
        for (int i : ladybugsField) {
            System.out.printf("%d ", i);
        }
    }
}
