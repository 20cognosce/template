package tinkoff.internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2 {

    public static void solveTask2() {
        Scanner scanner = new Scanner(System.in);

        List<Double> currencyValues = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<Double> currencyAmounts = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        double a = currencyValues.get(0); //1
        double b = currencyValues.get(1); //2
        double c = currencyValues.get(2); //3

        double x = currencyAmounts.get(0); //3
        double y = currencyAmounts.get(1); //5
        double z = currencyAmounts.get(2); //4

        double max = Math.max(a, Math.max(b, c)); //c

        double aCoef = max / a; // 3
        double bCoef = max / b; // 3/2
        double cCoef = max / c; // 1

        double sum = aCoef * x + bCoef * y + cCoef * z; //20.5

        List<Triple> triples = new ArrayList<>();
        int counter = 0;
        for (x = x % a; x <= sum; x += a) {
            for (y = y % b; y <= sum; y += b) {
                for (z = z % c; z <= sum; z += c) {
                    if (aCoef * x + bCoef * y + cCoef * z == sum) {
                        ++counter;
                        triples.add(new Triple(x, y, z));
                    }
                }
            }
        }

        System.out.println(counter);
    }

    public static class Triple {
        private final double x;
        private final double y;
        private final double z;


        public Triple(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }
}
