package JCF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkiedList {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        // head ->[5] -> [1] -> [2] -> [3]
        List<Integer> arrayList = new ArrayList<>();
        // [7][6][1][2][3][4][5]

        measureTime(linkedList);
        measureTime(arrayList);
    }

    public static void measureTime(List<Integer> list) {

        long start = System.currentTimeMillis();

        for(int i = 0; i < 100_000; i++) {
            list.add(0, i);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
