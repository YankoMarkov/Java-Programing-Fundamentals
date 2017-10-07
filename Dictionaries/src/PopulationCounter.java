import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Long>> countryAndCity = new LinkedHashMap<>();
        Map<String, Long> onlyCountry = new LinkedHashMap<>();
        String inputs = null;

        while (!(inputs = scan.nextLine()).equals("report")) {
            String[] input = inputs.split("\\|");
            String city = input[0];
            String country = input[1];
            long population = Integer.valueOf(input[2]);

            if (!countryAndCity.containsKey(country)) {
                countryAndCity.put(country, new LinkedHashMap<>());
                onlyCountry.put(country, 0L);
            }
            onlyCountry.put(country, onlyCountry.get(country) + population);
            if (!countryAndCity.get(country).containsKey(city)) {
                countryAndCity.get(country).put(city, population);
            }

        }
        countryAndCity.entrySet().stream()
                .sorted((p1, p2) -> onlyCountry.get(p2.getKey()).compareTo(onlyCountry.get(p1.getKey())))
                .forEach(country -> {
                    System.out.printf("%s (total population: %d)%n", country.getKey(), onlyCountry.get(country.getKey()));
                    country.getValue().entrySet().stream()
                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                            .forEach(city ->
                                    System.out.printf("=>%s: %d%n", city.getKey(), city.getValue()));
                });
    }
}
