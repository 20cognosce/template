package yandex.contest.task2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        Map<Integer, Integer> sumMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String entry = scanner.nextLine();
            List<Integer> array = convertLogEntryToIntArray(Arrays.stream(entry.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
            int value;
            int id = array.get(1);
            if (array.get(2) == 66) {
                continue;
            }
            if (array.get(2) == 65) {
                value = -array.get(0);
            } else {
                value = array.get(0);
            }

            int previousValue = Objects.isNull(sumMap.get(id)) ? 0 : sumMap.get(id);
            sumMap.put(id, previousValue + value);
        }

        var resultRef = new Object() {
            String result = "";
        };

        sumMap.values().forEach((value) -> resultRef.result = resultRef.result + value + " ");
        System.out.println(resultRef.result.substring(0, resultRef.result.length() - 1));
    }

    public static List<Integer> convertLogEntryToIntArray (List<Integer> rocketLog) {
        int e1 = rocketLog.get(0) * 24 * 60 + rocketLog.get(1) * 60 + rocketLog.get(2);
        int e2 = rocketLog.get(3); //id
        int e3 = rocketLog.get(4);
        return List.of(e1, e2, e3);
    }

    /*public static void sortDatabaseByOrderTime(Map<Integer, Map<LocalDateTime, Character>> database) {
        database.forEach((key, map) -> database.put(key, map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new))));
    }*/
}
