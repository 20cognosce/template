package leetcode.task2;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        String s = "\"A man, a plan, a canal: Panama\"";
        System.out.println(isPalindrome2(s));
    }

    public static boolean isPalindrome1(String s) {
        String input = s;
        input = input.replaceAll("[^a-zA-Z\\d]", "");
        input = input.strip();
        input = input.toLowerCase();

        int midIndex = input.length() / 2;

        String firstHalf = input.substring(0, midIndex);
        String secondHalf = input.length() % 2 == 0 ? input.substring(midIndex) : input.substring(midIndex + 1);

        String reversedSecondHalf = new StringBuilder(secondHalf).reverse().toString();

        return Objects.equals(firstHalf, reversedSecondHalf);
    }

    public static boolean isPalindrome2(String s) {
        s = s.replaceAll("[^a-zA-Z\\d]", "").toLowerCase();
        char[] input = s.toCharArray();

        if (input.length < 2) {
            return true;
        }

        int midIndex = input.length / 2;
        boolean flag = true;

        for (int i = 0; i <= midIndex; i++) {
            if (input[i] != input[input.length - 1 - i]) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}