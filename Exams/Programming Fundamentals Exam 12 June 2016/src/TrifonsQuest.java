import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrifonsQuest {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        long healthPoint = Long.valueOf(read.readLine());
        String[] rowCol = read.readLine().split("\\s+");
        int rows = Integer.valueOf(rowCol[0]);
        int cols = Integer.valueOf(rowCol[1]);
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String inputs = read.readLine();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputs.charAt(col);
            }
        }
        boolean move = true;
        int turns = 0;
        for (int col = 0; col < cols; col++) {
            if (move) {
                for (int row = 0; row < rows; row++) {
                    if (matrix[row][col] == 'F') {
                        healthPoint -= turns / 2;
                    }
                    if (matrix[row][col] == 'H') {
                        healthPoint += turns / 3;
                    }
                    if (matrix[row][col] == 'T') {
                        turns += 2;
                    }
                    if (healthPoint <= 0) {
                        System.out.printf("Died at: [%d, %d]", row, col);
                        return;
                    }
                    turns++;
                    move = false;
                }
            } else {
                for (int row = rows - 1; row >= 0; row--) {
                    if (matrix[row][col] == 'F') {
                        healthPoint -= turns / 2;
                    }
                    if (matrix[row][col] == 'H') {
                        healthPoint += turns / 3;
                    }
                    if (matrix[row][col] == 'T') {
                        turns += 2;
                    }
                    if (healthPoint <= 0) {
                        System.out.printf("Died at: [%d, %d]", row, col);
                        return;
                    }
                    turns++;
                    move = true;
                }
            }
        }
        System.out.printf("Quest completed!\nHealth: %d\nTurns: %d\n", healthPoint, turns);
    }
}
