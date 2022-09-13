package tinkoff.internship;

import java.util.Scanner;

public class Task3 {

    public static void solveTask3() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] pair = new int[2];
        int leastCommonMultiple = Integer.MAX_VALUE;

        for (int i = 1; i < n/2 + 1; i++) {
            int b = n-i;

            int currentLeastCommonMultiple = i * b / gcd(i, b);

            if (currentLeastCommonMultiple < leastCommonMultiple) {
                leastCommonMultiple = currentLeastCommonMultiple;
                pair[0] = i;
                pair[1] = b;
            }
        }

        System.out.printf("%s %s", pair[0], pair[1]);
    }

    public static int gcd(int number1, int number2) {
        if (number1 == 0 || number2 == 0) {
            return number1 + number2;
        } else {
            int absNumber1 = Math.abs(number1);
            int absNumber2 = Math.abs(number2);
            int biggerValue = Math.max(absNumber1, absNumber2);
            int smallerValue = Math.min(absNumber1, absNumber2);
            return gcd(biggerValue % smallerValue, smallerValue);
        }
    }
}
