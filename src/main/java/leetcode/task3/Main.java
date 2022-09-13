package leetcode.task3;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public List<LocalTime> laps = new ArrayList<>();

    public static void main(String[] args) {
        Character[] arr = new Character[] {'a','b','c',' ','d','e',' ','f'};

        Set<Character> characterSet = new HashSet<>(Arrays.asList(arr));

        System.out.println(Arrays.toString(reverse(arr)));
    }

    public static Character[] reverse(Character[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }
}
