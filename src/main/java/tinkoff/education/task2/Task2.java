package tinkoff.education.task2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Task2 {

    private static final Map<Integer, Boolean> measurementHistory = new LinkedHashMap<>();

    public static void main(String[] args) {
        readMeasurements();

        int[] x = {Integer.MIN_VALUE, Integer.MAX_VALUE};

        AtomicInteger previousDay = new AtomicInteger(0);
        AtomicInteger totalKeySum = new AtomicInteger(0);

        measurementHistory.forEach((key, value) -> {
            if (value) {
                previousDay.getAndAdd(key);
                x[0] = -previousDay.get();

                totalKeySum.getAndAdd(key);
            } else {
                previousDay.getAndAdd(key);
                x[1] = -previousDay.get() - 1;

                totalKeySum.getAndAdd(key);
            }
        });

        if (x[1] == Integer.MAX_VALUE) {
            System.out.println("inf");
        } else {
            System.out.println(x[1] + totalKeySum.get());
        }
    }

    private static void readMeasurements() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] parameters = scanner.nextLine().split(" ");

            int difference = Integer.parseInt(parameters[0]);
            Boolean isTemperatureZeroOrAbove = "0+".equals(parameters[1]);

            measurementHistory.put(difference, isTemperatureZeroOrAbove);
        }
    }
}
