package yandex.contest.task1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.nextLine();
        String resultString = "";

        for (int i = 0; i < n; i++) {
            if (!Objects.equals(resultString, "")) {
                resultString = resultString + " ";
            }
            String code = getCodeFromCandidate();
            resultString = resultString + code;
        }
        System.out.println(resultString);
    }

    public static String getCodeFromCandidate() {
        String arrAsLine = scanner.nextLine();
        List<String> arr = Arrays.stream(arrAsLine.split(",")).collect(Collectors.toList());

        int numberOfUniqueCharacters = countUniqueCharacters(arr.get(0) + arr.get(1) + arr.get(2));
        int sumOfDayAndMonthDigits = getSumOfDigitsOfTwoNumbers(Integer.parseInt(arr.get(3)), Integer.parseInt(arr.get(4)));
        int numberOfTheCharacterInLatinAlphabet = arr.get(0).charAt(0) - 65 + 1; //A = 65 in ascii

        int preCode = numberOfUniqueCharacters + sumOfDayAndMonthDigits * 64 + numberOfTheCharacterInLatinAlphabet * 256;
        String preCodeIn16Base = Integer.toHexString(preCode);
        return preCodeIn16Base.substring(preCodeIn16Base.length() - 3).toUpperCase();
    }

    public static int countUniqueCharacters(String line) {
        HashSet<Character> s = new HashSet<>();
        for(int i = 0; i < line.length(); i++) {
            s.add(line.charAt(i));
        }

        return s.size();
    }

    public static int getSumOfDigitsOfTwoNumbers(int a, int b) {
        int sum = 0;

        while (a > 0) {
            sum += a % 10;
            a = a / 10;
        }

        while (b > 0) {
            sum += b % 10;
            b = b / 10;
        }

        return sum;
    }
}
