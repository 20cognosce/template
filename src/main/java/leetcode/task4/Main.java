package leetcode.task4;

import org.springframework.cglib.core.Local;

import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        int[][] arr = new int [][] {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        int[][] arr2 = new int [][] {
                {0,1},
                {0,3},
                {0,2},
                {4,6},
                {4,5}
        };

       //Arrays.sort(arr2, (a, b) -> Integer.compare(a[0], b[0]));
       //System.out.println(Arrays.deepToString(arr2));

      // System.out.println(Arrays.deepToString(merge2(arr2)));

        List<leetcode.task3.Main> mains = new ArrayList<>();
        leetcode.task3.Main main1 = new leetcode.task3.Main();
        main1.laps.add(LocalTime.of(1,2));
        main1.laps.add(LocalTime.of(0,4));
        leetcode.task3.Main main2 = new leetcode.task3.Main();
        main2.laps.add(LocalTime.of(1,1));
        main2.laps.add(LocalTime.of(0,2));
        leetcode.task3.Main main3 = new leetcode.task3.Main();
        main3.laps.add(LocalTime.of(2,16));
        main3.laps.add(LocalTime.of(0,3));

        mains.add(main1);
        mains.add(main2);
        mains.add(main3);
        System.out.println(min(mains));
    }

    public static int[][] merge(int[][] intervals) {
        List<List<Integer>> listOfIntervals = new ArrayList<>();
        for (int[] ints : intervals) {
            listOfIntervals.add(Arrays.stream(ints).boxed().collect(Collectors.toList()));
        }

        listOfIntervals.forEach(e -> {

            Optional<List<Integer>> candidateToMerge = listOfIntervals.stream()
                    .filter(interval -> {
                        if (Objects.nonNull(interval) && !Objects.equals(e, interval)) {
                            return e.get(0) <= interval.get(1) && e.get(1) >= interval.get(0);
                        }
                        return false;
                    })
                    .findFirst();

            if (candidateToMerge.isPresent()) {
                List<Integer> intervalToMerge = candidateToMerge.get();
                Integer leftIndex = e.get(0) <= intervalToMerge.get(0) ? e.get(0) : intervalToMerge.get(0);
                Integer rightIndex = e.get(1) >= intervalToMerge.get(1) ? e.get(1) : intervalToMerge.get(1);
                listOfIntervals.set(listOfIntervals.indexOf(intervalToMerge), new ArrayList<>(List.of(leftIndex, rightIndex)));
                listOfIntervals.set(listOfIntervals.indexOf(e), null);
            }
        });

        List<List<Integer>> resultListOfIntervals = listOfIntervals.stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());

        int[][] result = new int[resultListOfIntervals.size()][2];

        for (int i = 0; i < result.length; i++) {
            result[i][0] = resultListOfIntervals.get(i).get(0);
            result[i][1] = resultListOfIntervals.get(i).get(1);
        }

        return result;
    }

    public static int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Deque<int[]> merged = new ArrayDeque<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static Map<LocalTime, leetcode.task3.Main> min(List<leetcode.task3.Main> mains) {

        return mains.stream()
                .map(main -> Map.entry(main.laps.stream().min(LocalTime::compareTo).orElseThrow(), main))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (previousValue, newValue) -> newValue,
                        TreeMap::new
                ));

        /*return mains.stream()
            .reduce(LocalTime.MAX,
                (accumulator, main) -> {
                        LocalTime minMainLap = main.laps.stream().min(LocalTime::compareTo).orElseThrow();
                        return accumulator.isBefore(minMainLap) ? accumulator : minMainLap;
                }, (minLocalTime, mainMinLapTime) -> minLocalTime = mainMinLapTime
            );*/

        /*
        return mains.stream()
                .map(main -> main.laps.stream()
                        .min(LocalTime::compareTo)
                        .orElseThrow(RuntimeException::new))
                .min(LocalTime::compareTo)
                .orElseThrow(RuntimeException::new);
                */

        /*
        return mains.stream()
                .flatMap(main -> main.laps.stream())
                .min(LocalTime::compareTo)
                .orElseThrow(RuntimeException::new);
                */
    }
}
