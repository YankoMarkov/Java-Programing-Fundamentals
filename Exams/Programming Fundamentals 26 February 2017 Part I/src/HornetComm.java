import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HornetComm {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<String> broadcasts = new LinkedList<>();
        List<String> messages = new LinkedList<>();
        String inputs = null;

        while (!(inputs = read.readLine()).equals("Hornet is Green")) {
            Pattern messagePattern = Pattern.compile("(?<message1>[0-9]+)\\s+<->\\s+\\b(?<message2>[0-9a-zA-Z]+)$");
            Pattern broadcastPattern = Pattern.compile("(?<broadcast1>[\\D]+)\\s+<->\\s+\\b(?<broadcast2>[0-9a-zA-Z]+)$");
            Matcher messageMatcher = messagePattern.matcher(inputs);
            Matcher broadcastMatcher = broadcastPattern.matcher(inputs);

            while (messageMatcher.find()) {
                String firstMessage = messageMatcher.group("message1");
                String secondMessage = messageMatcher.group("message2");
                StringBuilder sb = new StringBuilder(firstMessage);
                String first = sb.reverse().toString();
                messages.add(first + " -> " + secondMessage);
            }
            while (broadcastMatcher.find()) {
                String firstBroadcast = broadcastMatcher.group("broadcast1");
                String secondBroadcast = broadcastMatcher.group("broadcast2");
                String first = "";
                for (int i = 0; i < secondBroadcast.length(); i++) {
                    char letter = secondBroadcast.charAt(i);
                    if (letter > 96 && letter < 123) {
                        String temp = Character.toString(letter).toUpperCase();
                        first += temp;
                    } else if (secondBroadcast.charAt(i) > 64 && secondBroadcast.charAt(i) < 91) {
                        String temp = Character.toString(letter).toLowerCase();
                        first += temp;
                    } else {
                        String temp = Character.toString(letter);
                        first += temp;
                    }
                }
                broadcasts.add(first + " -> " + firstBroadcast);
            }
        }
        System.out.println("Broadcasts:");
        if (broadcasts.isEmpty()) {
            System.out.println("None");
        } else {
            for (String broadcast : broadcasts) {
                System.out.println(broadcast);
            }
        }
        System.out.println("Messages:");
        if (messages.isEmpty()) {
            System.out.println("None");
        } else {
            for (String message : messages) {
                System.out.println(message);
            }
        }
    }
}
