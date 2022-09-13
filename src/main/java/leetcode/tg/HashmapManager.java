package leetcode.tg;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class HashmapManager {

    public static void manipulateHashmap() throws NoSuchFieldException, IllegalAccessException {
        Map<Integer, Integer> bruh = new HashMap<>(9);
        Field table;

        for (int i = 1; i <= 25; i++) {
            bruh.put(i, i);

            table = HashMap.class.getDeclaredField("table");
            table.setAccessible(true);
            System.out.printf("%s: %s\n", i, ((Object[]) table.get(bruh)).length);
        }
    }
}
