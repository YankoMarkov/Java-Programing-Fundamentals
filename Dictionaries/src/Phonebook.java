import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        String inputs = null;

        while (!(inputs = scan.nextLine()).equals("END")) {
            String[] input = inputs.split("\\s+");
            String command = input[0];
            String name = input[1];

            if (command.equals("A")) {
                String phone = input[2];
                if (!map.containsKey(name)) {
                    map.put(name, phone);
                }
                if (!map.get(name).equals(phone)) {
                    map.replace(name, phone);
                }
            }
            if (command.equals("S")) {
                if (map.containsKey(name)) {
                    System.out.printf("%s -> %s%n", name, map.get(name));
                } else {
                    System.out.printf("Contact %s does not exist.%n", name);
                }
            }
        }
    }
}
