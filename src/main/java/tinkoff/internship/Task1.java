package tinkoff.internship;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Task1 {

    public static void solveTask1() {
        Scanner scanner = new Scanner(System.in);

        Integer n = scanner.nextInt();
        scanner.nextLine();
        String name = scanner.nextLine();
        var ref = new Object() {
            String paintRule = scanner.nextLine();
        };

        List<String> wordsInName = Arrays.stream(name.split(" ")).collect(Collectors.toList());

        AtomicInteger i = new AtomicInteger(0);
        wordsInName.forEach(word -> {
            int length = word.length();
            String paintRuleForCurrentWord = ref.paintRule.substring(0, length);

            if (paintRuleForCurrentWord.contains("YY") || paintRuleForCurrentWord.contains("BB")) {
                i.incrementAndGet();
            }

            ref.paintRule = ref.paintRule.substring(length);
        });

        System.out.println(i.get());
    }
}
