import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        String input;

        while (!(input = scan.nextLine()).equals("stop")) {
            int num = Integer.valueOf(scan.nextLine());
            if (!map.containsKey(input)) {
                map.put(input, num);
            } else {
                map.put(input, map.get(input) + num);
            }
        }
        for (Map.Entry<String, Integer> resources : map.entrySet()) {
            System.out.printf("%s -> %s\n", resources.getKey(), resources.getValue());
        }
    }
}
