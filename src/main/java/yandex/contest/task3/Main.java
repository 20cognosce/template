package yandex.contest.task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        StringBuilder result = new StringBuilder();
        for (Integer i : list) {
            result.append(dist(i, getOptimalList(i, k, list))).append(" ");
        }
        System.out.println(result.toString().trim());
    }

    public static int dist(int i, List<Integer> list) {
        return list.stream().mapToInt(e -> Math.abs(i - e)).sum();
    }

    public static List<Integer> getOptimalList(int i, int k, List<Integer> list) {
        List<Integer> copy = new ArrayList<>(list);
        copy.remove(Integer.valueOf(i));
        return copy.stream().sorted(Comparator.comparingInt(e -> Math.abs(e - i))).limit(k).collect(Collectors.toList());
    }
}