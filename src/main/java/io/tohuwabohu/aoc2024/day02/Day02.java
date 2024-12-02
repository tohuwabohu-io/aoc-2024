package io.tohuwabohu.aoc2024.day02;

import io.tohuwabohu.util.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Day02 {
    private final int minDiff = 1;
    private final int maxDiff = 3;

    public long part1(String fileName) throws FileNotFoundException {
        var bufferedReader = new BufferedReader(new FileReader(fileName));

        return bufferedReader.lines()
            .map(line -> Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).boxed().toList())
            .map(Util::consecutive)
            .filter(pairs -> {
                int direction = pairs.get(0).a > pairs.get(0).b ? 1 : -1;

                return pairs.stream().allMatch(pair -> compare(direction, pair.a, pair.b));
            }).count();
    }

    private boolean compare(int direction, int a, int b) {
        if (Math.abs(a - b) < minDiff || Math.abs(a - b) > maxDiff) {
            return false;
        }

        // lower
        if (direction == 1 && (a > b)) { // greater
            return true;
        } else return direction == -1 && (a < b);
    }
}
