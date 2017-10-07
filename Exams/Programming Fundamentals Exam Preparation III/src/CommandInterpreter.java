import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommandInterpreter {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputs = Arrays.stream(read.readLine().split("\\s+")).map(String::valueOf).collect(Collectors.toList());
        String commands = null;

        while (!(commands = read.readLine()).equals("end")) {
            String[] command = commands.split("\\s+");
            int index = 0;
            int count = 0;
            List<String> temp = new ArrayList<>();

            switch (command[0]) {
                case "reverse":
                    index = Integer.valueOf(command[2]);
                    count = Integer.valueOf(command[4]);
                    if (index < 0 || index > inputs.size() - 1 || count < 0 || count > inputs.size() - index) {
                        System.out.println("Invalid input parameters.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            temp.add(inputs.remove(index));
                        }
                        Collections.reverse(temp);
                        inputs.addAll(index, temp);
                    }
                    break;
                case "sort":
                    index = Integer.valueOf(command[2]);
                    count = Integer.valueOf(command[4]);
                    if (index < 0 || index > inputs.size() - 1 || count < 0 || count > inputs.size() - index) {
                        System.out.println("Invalid input parameters.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            temp.add(inputs.remove(index));
                        }
                        Collections.sort(temp);
                        inputs.addAll(index, temp);
                    }
                    break;
                case "rollLeft":
                    count = Integer.valueOf(command[1]);
                    index = count % inputs.size();
                    if (count < 0) {
                        System.out.println("Invalid input parameters.");
                    } else {
                        for (int i = 0; i < inputs.size(); i++) {
                            temp.add(inputs.get(index % inputs.size()));
                            index++;
                        }
                        inputs = temp;
                    }
                    break;
                case "rollRight":
                    count = Integer.valueOf(command[1]);
                    index = inputs.size() - (count % inputs.size());
                    if (index == inputs.size()) {
                        index = 0;
                    }
                    if (count < 0) {
                        System.out.println("Invalid input parameters.");
                    } else {
                        for (int i = 0; i < inputs.size(); i++) {
                            temp.add(inputs.get(index % inputs.size()));
                            index++;
                        }
                        inputs = temp;
                    }
                    break;
            }
        }
        System.out.println(inputs);
    }
}
