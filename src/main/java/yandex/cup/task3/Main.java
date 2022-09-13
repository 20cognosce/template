package yandex.cup.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.replaceAll(" ", "");

        List<String> numbers = new ArrayList<>();

        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            final char c = s.charAt(i);

            if (c == '-' || c == '+' || c == '=') {
                numbers.add(temp.toString());
                numbers.add(String.valueOf(c));
                temp.setLength(0);
                continue;
            }

            temp.append(c);
        }
        numbers.add(temp.toString());

        List<String> leftPart = new ArrayList<>();
        List<String> rightPart = new ArrayList<>();
        boolean left = true;

        for (int i = 0; i < numbers.size(); i++) {
            String element = numbers.get(i);

            if (element.charAt(0) == '+') {
                continue;
            }

            if (element.charAt(0) == '=') {
                left = false;
                continue;
            }

            if (element.charAt(0) == '-') {
                element = numbers.get(++i);
                if (left) {
                    rightPart.add(element);
                } else {
                    leftPart.add(element);
                }
            } else if (left) {
                leftPart.add(element);
            } else {
                rightPart.add(element);
            }
        }

        int i = 2;
        while (!checkSum(leftPart, rightPart, i) && i < 37) {
            ++i;
        }
        System.out.println(i == 37 ? -1 : i);
    }

    public static boolean checkSum(List<String> leftPart, List<String> rightPart, int sBase) {
        try {
            int sum1 = leftPart.stream().mapToInt(number -> Integer.parseInt(number, sBase)).sum();
            int sum2 = rightPart.stream().mapToInt(number -> Integer.parseInt(number, sBase)).sum();
            return sum1 == sum2;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
