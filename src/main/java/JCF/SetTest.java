package JCF;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        Set<String> HashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        HashSet.add("Mike");
        HashSet.add("Katy");
        HashSet.add("Tom");
        HashSet.add("George");
        HashSet.add("Donald");

        System.out.println(HashSet.contains("Tom"));
        System.out.println(HashSet.contains("Tim"));
        System.out.println(HashSet.isEmpty());
    }
}
