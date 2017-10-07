import java.util.*;

public class HandsOfCards {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, HashSet<String>> map = new LinkedHashMap<>();
        List<Character> powers = Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K', 'A');
        List<Character> types = Arrays.asList('C', 'D', 'H', 'S');
        String inputs = null;

        while (!(inputs = scan.nextLine()).equals("JOKER")) {
            String[] input = inputs.split(": ");
            String name = input[0];
            String[] cards = input[1].split(", ");

            if (!map.containsKey(name)) {
                map.put(name, new HashSet<>());
            }
            for (String card : cards) {
                map.get(name).add(card);
            }
        }
        for (String name : map.keySet()) {
            System.out.printf("%s: ", name);
            int sum = 0;
            for (String card : map.get(name)) {
                int power = powers.indexOf(card.charAt(0)) + 2;
                int type = types.indexOf(card.charAt(card.length() - 1)) + 1;
                sum += power * type;
            }
            System.out.println(sum);
        }
    }
}
