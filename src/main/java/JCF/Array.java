package JCF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 100; i++ ) {
            list.add(i);
        }
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for(Integer x : list)
            System.out.println(x);

        list = new LinkedList<>();
    }
}
