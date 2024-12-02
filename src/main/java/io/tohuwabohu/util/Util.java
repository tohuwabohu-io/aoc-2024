package io.tohuwabohu.util;

import java.util.LinkedList;
import java.util.List;

public class Util {
    public static List<Pair> consecutive(List<Integer> list) {
        List<Pair> pairs = new LinkedList<>();
        list.stream().reduce((a, b) -> {
            pairs.add(new Pair(a, b));
            return b;
        });
        return pairs;
    }
}
