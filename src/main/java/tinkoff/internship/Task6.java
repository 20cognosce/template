package tinkoff.internship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {

    public static void solveTask6() {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        List<Integer> array = new ArrayList<>();
        List<Integer> intermediateMaxXors = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int e = scanner.nextInt();
            array.add(e);

            intermediateMaxXors.add(calculateMaxXor(array));
        }

        intermediateMaxXors.forEach(System.out::println);
    }

    public static int calculateMaxXor(List<Integer> numbers) {
        int maxXor = 0;
        int[] array = numbers.stream().mapToInt(i -> i).toArray();

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int currentPairXor = array[i]^array[j];
                if (currentPairXor > maxXor) {
                    maxXor = currentPairXor;
                }
            }
        }

        return maxXor;
    }
}
