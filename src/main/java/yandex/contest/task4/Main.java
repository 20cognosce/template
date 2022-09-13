package yandex.contest.task4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 2, 3, 6, 1, 7 ,7, 8, 9, 8, 6));

        System.out.println(arr);
        System.out.println(arr.stream().filter(e -> arr.indexOf(e) == arr.lastIndexOf(e)).findAny().orElseThrow());

    }
}
