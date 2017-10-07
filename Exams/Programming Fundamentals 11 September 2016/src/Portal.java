
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Portal {

    private static char[][] matrix;
    private static int col;
    private static int row;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(read.readLine().trim());
        if (num <= 0) {
            System.out.println("Robot stuck at 0 0. Experiment failed.");
        }
        matrix = new char[num][];

        for (int i = 0; i < num; i++) {
            matrix[i] = read.readLine().trim().toLowerCase().toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 's') {
                    row = i;
                    col = j;
                }
            }
        }
        String command = read.readLine().trim().toLowerCase();
        count = 0;
        for (char c : command.toCharArray()) {
            if (move(c)) {
                System.out.printf("Experiment successful. %d turns required.", count);
                return;
            }
        }
        System.out.printf("Robot stuck at %d %d. Experiment failed.", row, col);
    }

    private static boolean move(char direction) {
        count++;
        switch (direction) {
            case 'd':
                return moveVertically(1);
            case 'u':
                return moveVertically(-1);
            case 'l':
                return moveHorizontally(-1);
            case 'r':
                return moveHorizontally(1);
            default:
                return false;
        }
    }

    private static boolean moveVertically(int delta) {
        do {
            row += delta;
            if (row >= matrix.length) {
                row = 0;
            } else if (row < 0) {
                row = matrix.length - 1;
            }
        } while (col >= matrix[row].length);
        return 'e' == matrix[row][col];
    }

    private static boolean moveHorizontally(int delta) {
        col += delta;
        if (col >= matrix[row].length) {
            col = 0;
        } else if (col < 0) {
            col = matrix[row].length - 1;
        }
        return 'e' == matrix[row][col];
    }
}
