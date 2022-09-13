package tinkoff.education.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    private static final List<String> digitSequence = new ArrayList<>() {{
        add("01");
        add("12");
        add("23");
        add("34");
        add("56");
        add("78");
        add("90");
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var ref = new Object() {
            String message = scanner.nextLine();
        };

        ref.message = ref.message.replace("?", "");

        boolean isMessageFromDima = digitSequence.stream()
                .anyMatch(sequence -> ref.message.contains(sequence));

        if (isMessageFromDima) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
