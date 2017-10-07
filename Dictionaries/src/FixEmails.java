import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> map = new LinkedHashMap<>();
        String name;

        while (!(name = scan.nextLine()).equals("stop")) {
            String email = scan.nextLine();
            String emailEnd = email.substring(email.length() - 2, email.length());
            if (!(emailEnd.equals("us") || emailEnd.equals("uc"))) {
                map.put(name, email);
            }
        }
        for (Map.Entry<String, String> fin : map.entrySet()) {
            System.out.printf("%s -> %s\n", fin.getKey(), fin.getValue());
        }
    }
}
