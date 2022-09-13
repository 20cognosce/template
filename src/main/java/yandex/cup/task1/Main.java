package yandex.cup.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final List<Datacenter> datacenters = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            datacenters.add(new Datacenter(m, i));
        }

        for (int i = 0; i < q; i++) {
            String event = scanner.nextLine();
            switch (event) {
                case "GETMIN": {
                    System.out.println(datacenters.stream()
                            .min(Comparator.comparingInt(datacenter -> datacenter.resetsNumber * datacenter.activeServersNumber))
                            .orElseThrow()
                            .id + 1
                    );
                } break;

                case "GETMAX": {
                    System.out.println(datacenters.stream()
                            .max(Comparator.comparingInt(datacenter -> datacenter.resetsNumber * datacenter.activeServersNumber))
                            .orElseThrow()
                            .id + 1
                    );
                } break;

                default: {
                    String[] commands = event.split(" ");
                    if (Objects.equals(commands[0], "RESET")) {
                        Datacenter datacenter = datacenters.get(Integer.parseInt(commands[1]) - 1);
                        datacenter.activeServersNumber = datacenter.allServersNumber;
                        ++datacenter.resetsNumber;
                    }
                    if (Objects.equals(commands[0], "DISABLE")) {
                        Datacenter datacenter = datacenters.get(Integer.parseInt(commands[1]) - 1);
                        --datacenter.activeServersNumber;
                    }
                }
            }

        }
    }

    public static class Datacenter {

        private final int id;
        private final int allServersNumber;
        private int activeServersNumber;
        private int resetsNumber = 0;

        public Datacenter(int serversNumber, int id) {
           allServersNumber = serversNumber;
           activeServersNumber = serversNumber;
           this.id = id;
        }
    }
}
