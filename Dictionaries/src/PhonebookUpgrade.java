import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PhonebookUpgrade {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> map = new TreeMap<>();
        String inputs = null;

        while (!(inputs = scan.nextLine()).equals("END")) {
            String[] input = inputs.split("\\s+");
            String command = input[0];

            if (command.equals("A")) {
                String name = input[1];
                String phone = input[2];
                if (!map.containsKey(name)) {
                    map.put(name, phone);
                }
                if (!map.get(name).equals(phone)) {
                    map.replace(name, phone);
                }
            }
            if (command.equals("ListAll")) {
                for (Map.Entry<String, String> result : map.entrySet()) {
                    System.out.printf("%s -> %s%n", result.getKey(), result.getValue());
                }
                break;
            }
        }
    }
}