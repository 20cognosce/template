package leetcode.ozon;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

    // Напишите программу на Java для подсчета количества конкретных слов в строке.

class WordsCounter {

    public static void main(String[] args) {

        //System.out.println(count("Мама мыла    раму мама ".repeat(4)));
        System.out.println(0x1);
        System.out.println(0x10);
        System.out.println(0x100);
        System.out.println(0x1000);
        System.out.println(0x10000);
        System.out.println(0x100000);
        System.out.println(0x1000000);
        System.out.println(0x10000000);
        System.out.println((int) (Math.pow(2, 32)));

        int k, z = 0;

        System.out.println(Integer.toHexString(-1000000000));
        System.out.println((0x0111 & (0x1000 - 1)) == 0);
    }

    public static void createManyThreads() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        AtomicInteger i = new AtomicInteger(0);

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution: " + i.incrementAndGet();
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        for (int j = 0; j < 100; j++) {
            callableTasks.add(callableTask);
        }

        List<Future<String>> futures;
        try {
            futures = executorService.invokeAll(callableTasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }

        AtomicInteger k = new AtomicInteger();
        futures.forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
                k.incrementAndGet();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(k);
    }

    public static Map<String, Long> count(String s) {
        // String -> List<String> (words), " "

        // a b b a a
        // a; 1
        // a

        // abc bca   qwer
        // abc Abc

        //abc
        //bca
        //
        //qwer

        String[] words = s.toLowerCase().split(" ");
        List<String> wordsAsList = Arrays.asList(words);

        /*Node<>[]

        putVal() {

            int hashcode = hash(key1);
            int i = hashcode >>
            if (hashcode == tab[i] && (
                    key1 == key2 || key.equals(k2))
        }

        @Override
                equals() {

            //a.equals(b)
        }

        @Override
                hashcode() {

        }*/

        AtomicInteger i = new AtomicInteger(0);
        List<List<String>> list = new ArrayList<>();

        for (int j = 0; j < 20; j++) {
            list.add(new ArrayList<>());
        }

        Map<String, Long> resultMap = wordsAsList.parallelStream()
                .filter(word -> word.length() > 0)
                .collect(Collectors.toMap(
                        e -> {
                            String threadName = Thread.currentThread().getName();
                            int index;
                            if (Objects.equals(threadName, "main")) {
                                index = 0;
                            } else {
                                String number = threadName.substring(threadName.length() - 2);
                                number = number.charAt(0) == '-' ? String.valueOf(number.charAt(1)) : number;
                                index = Integer.parseInt(number);
                            }
                            String message = e + " " + LocalTime.now() + " " + i.incrementAndGet();
                            list.get(index).add(message);
                            return e;
                        },
                        e -> 1L,
                        (existing, newOccurrence) -> {
                            String threadName = Thread.currentThread().getName();
                            int index;
                            if (Objects.equals(threadName, "main")) {
                                index = 0;
                            } else {
                                String number = threadName.substring(threadName.length() - 2);
                                number = number.charAt(0) == '-' ? String.valueOf(number.charAt(1)) : number;
                                index = Integer.parseInt(number);
                            }
                            String message = existing + " " + newOccurrence + " " + LocalTime.now() + " " + i.incrementAndGet();
                            list.get(index).add(message);
                            return existing + newOccurrence;
                        })
                );

        for (List<String> strings : list) {
            System.out.println(strings);
        }

        return resultMap;
    }
}





