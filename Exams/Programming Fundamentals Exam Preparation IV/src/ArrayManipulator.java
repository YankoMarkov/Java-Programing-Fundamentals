import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayManipulator {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> array = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());

        String input = null;
        while (!(input = read.readLine()).equals("end")) {
            String[] command = input.split("\\s+");
            int index = 0;
            int count = 0;
            List<Integer> temp = new ArrayList<>();

            switch (command[0]) {
                case "exchange":
                    index = Integer.valueOf(command[1]);
                    int startIndex = index + 1;
                    if (index == array.size() - 1) {
                        startIndex = 0;
                    }
                    if (index > array.size() - 1 || index < 0) {
                        System.out.println("Invalid index");
                    } else {
                        for (int i = 0; i < array.size(); i++) {
                            temp.add(array.get(startIndex % array.size()));
                            startIndex++;
                        }
                        array = temp;
                    }
                    break;
                case "max":
                    if (command[1].equals("even")) {
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) % 2 == 0) {
                                temp.add(array.get(i));
                            }
                        }
                        if (temp.size() == 0) {
                            System.out.println("No matches");
                        } else {
                            Collections.sort(temp);
                            index = array.lastIndexOf(temp.get(temp.size() - 1));
                            System.out.println(index);
                        }
                    } else if (command[1].equals("odd")) {
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) % 2 != 0) {
                                temp.add(array.get(i));
                            }
                        }
                        if (temp.size() == 0) {
                            System.out.println("No matches");
                        } else {
                            Collections.sort(temp);
                            index = array.lastIndexOf(temp.get(temp.size() - 1));
                            System.out.println(index);
                        }
                    }
                    break;
                case "min":
                    if (command[1].equals("even")) {
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) % 2 == 0) {
                                temp.add(array.get(i));
                            }
                        }
                        if (temp.size() == 0) {
                            System.out.println("No matches");
                        } else {
                            Collections.sort(temp);
                            index = array.lastIndexOf(temp.get(0));
                            System.out.println(index);
                        }
                    } else if (command[1].equals("odd")) {
                        for (int i = 0; i < array.size(); i++) {
                            if (array.get(i) % 2 != 0) {
                                temp.add(array.get(i));
                            }
                        }
                        if (temp.size() == 0) {
                            System.out.println("No matches");
                        } else {
                            Collections.sort(temp);
                            index = array.lastIndexOf(temp.get(0));
                            System.out.println(index);
                        }
                    }
                    break;
                case "first":
                    count = Integer.valueOf(command[1]);
                    if (count > array.size() || count < 0) {
                        System.out.println("Invalid count");
                        break;
                    }
                    if (command[2].equals("even")) {
                        for (int i = 0; i < array.size(); i++) {
                            if (count == temp.size()) {
                                break;
                            }
                            if (array.get(i) % 2 == 0) {
                                temp.add(array.get(i));
                            }
                        }
                        System.out.println(temp);
                    } else if (command[2].equals("odd")) {
                        for (int i = 0; i < array.size(); i++) {
                            if (count == temp.size()) {
                                break;
                            }
                            if (array.get(i) % 2 != 0) {
                                temp.add(array.get(i));
                            }
                        }
                        System.out.println(temp);
                    }
                    break;
                case "last":
                    count = Integer.valueOf(command[1]);
                    if (count > array.size() || count < 0) {
                        System.out.println("Invalid count");
                        break;
                    }
                    if (command[2].equals("even")) {
                        for (int i = array.size() - 1; i >= 0; i--) {
                            if (count == temp.size()) {
                                break;
                            }
                            if (array.get(i) % 2 == 0) {
                                temp.add(array.get(i));
                            }
                        }
                        System.out.println(temp);
                    } else if (command[2].equals("odd")) {
                        for (int i = array.size() - 1; i >= 0; i--) {
                            if (count == temp.size()) {
                                break;
                            }
                            if (array.get(i) % 2 != 0) {
                                temp.add(array.get(i));
                            }
                        }
                        System.out.println(temp);
                    }
                    break;
            }
        }
        System.out.println(array);
    }
}
