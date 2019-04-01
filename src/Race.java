import java.util.*;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] participants = scan.nextLine().split(", ");
        Map<String, Integer> racers = new LinkedHashMap<>();

        for (String participant : participants) {
            racers.putIfAbsent(participant, 0);
        }

        String input;
        while (!"end of race".equals(input = scan.nextLine())) {
            StringBuilder name = new StringBuilder();
            int distance = 0;

            for (int i = 0; i < input.length(); i++) {
                if (Character.isLetter(input.charAt(i))) {
                    name.append(input.charAt(i));
                } else if (Character.isDigit(input.charAt(i))) {
                    distance += Character.getNumericValue(input.charAt(i));
                }
            }

            if (racers.containsKey(name.toString())) {
                racers.put(name.toString(), racers.get(name.toString()) + distance);
            }
        }

        racers = racers.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k, v) -> {throw new AssertionError();},
                        LinkedHashMap::new
                ));

        String[] names = new String[3];
        int index = 0;

        for (String key : racers.keySet()) {
            names[index++] = key;
        }

        System.out.println("1st place: " + names[0]);
        System.out.println("2nd place: " + names[1]);
        System.out.println("3rd place: " + names[2]);
    }
}
