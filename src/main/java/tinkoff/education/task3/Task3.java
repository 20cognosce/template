package tinkoff.education.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {

    private static final List<Telescope> telescopes = new ArrayList<>();
    private static final List<Star> stars = new ArrayList<>();


    public static void main(String[] args) {
        readInfo();

        Map<Integer, Integer> modesFrequencyMap = new HashMap<>();

        stars.forEach(star -> star.getStarTelescopes().forEach(telescope -> {
            int mode = telescope.getMode();

            if (modesFrequencyMap.get(mode) == null) {
                modesFrequencyMap.put(mode, 1);
            } else {
                modesFrequencyMap.computeIfPresent(mode, (key, value) -> ++value);
            }
        }));

        AtomicInteger counter = new AtomicInteger();

        stars.forEach(star -> {
            int mode1 = star.getStarTelescopes().get(0).getMode();
            int mode2 = star.getStarTelescopes().get(1).getMode();

            if (mode1 != mode2) {
                if (modesFrequencyMap.get(mode1) > modesFrequencyMap.get(mode2)) {
                    star.getStarTelescopes().get(1).setMode(mode1);
                } else {
                    star.getStarTelescopes().get(0).setMode(mode2);
                }

                counter.getAndIncrement();
            }
        });

        System.out.println(counter);
    }


    private static void readInfo() {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(" ");
        String[] modesLine = scanner.nextLine().split(" ");

        int telescopesNumber = Integer.parseInt(firstLine[0]);
        int starsNumber = Integer.parseInt(firstLine[1]);
        int modesNumber = Integer.parseInt(firstLine[2]); //unnecessary

        for (int i = 0; i < telescopesNumber; i++) {
            telescopes.add(new Telescope(Integer.parseInt(modesLine[i]), i));
        }

        for (int i = 0; i < starsNumber; i++) {
            String[] telescopesForStar = scanner.nextLine().split(" ");

            stars.add(new Star(
                            new ArrayList<>(List.of(
                                    telescopes.get(Integer.parseInt(telescopesForStar[0]) - 1),
                                    telescopes.get(Integer.parseInt(telescopesForStar[1]) - 1)))
                    )
            );
        }
    }

    private static class Telescope {
        private final int id;
        private int mode;

        public Telescope(int mode, int id) {
            this.mode = mode;
            this.id = id;
        }

        public int getMode() {
            return mode;
        }

        public void setMode(int mode) {
            this.mode = mode;
        }

        @Override
        public String toString() {
            return "Telescope{" +
                    "id=" + id +
                    ", mode=" + mode +
                    '}';
        }
    }

    private static class Star {
        private final List<Telescope> starTelescopes;

        public Star(List<Telescope> starTelescopes) {
            this.starTelescopes = starTelescopes;
        }

        public List<Telescope> getStarTelescopes() {
            return starTelescopes;
        }

        @Override
        public String toString() {
            return "Star{" +
                    "starTelescopes=" + starTelescopes +
                    '}';
        }
    }
}
