package tinkoff.education;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final List<Integer> frequencies = new ArrayList<>();

    public static void main(String[] args) {
        readInfo();

        Map<Integer, Integer> centralProcessorToFrequencySumMap = new HashMap<>();

        //O(n^2), I know
        frequencies.forEach(centralFreq -> {
            AtomicInteger tempSum = new AtomicInteger(0);

            frequencies.forEach(comparingFreq -> {
                if (comparingFreq < centralFreq) {
                    return;
                }

                while (comparingFreq % centralFreq != 0) {
                    --comparingFreq;
                }

                tempSum.addAndGet(comparingFreq);
            });

            centralProcessorToFrequencySumMap.put(centralFreq, tempSum.get());
        });

        int result = centralProcessorToFrequencySumMap.values()
                .stream()
                .max(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new);

        System.out.println(result);
    }

    private static void readInfo() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String[] parameters = scanner.nextLine().split(" ");

        Arrays.stream(parameters).forEach(frequency -> {
            frequencies.add(Integer.parseInt(frequency));
        });
    }
}
