package leetcode.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final Map<String, String> rides = new HashMap<>(Map.of(
            "Москва", "Санкт-Петербург",
            "Краснодар", "Рязань",
            "Рязань","Москва"
    ));

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();

        Set<String> departureCities = new HashSet<>(rides.keySet());
        departureCities.removeAll(new HashSet<>(rides.values()));
        String startPoint = departureCities.iterator().next();

        String destination;
        while ((destination = rides.get(startPoint)) != null) {
            result.add(startPoint);
            startPoint = destination;
        }
        result.add(startPoint);
        System.out.println(result);
    }
}
