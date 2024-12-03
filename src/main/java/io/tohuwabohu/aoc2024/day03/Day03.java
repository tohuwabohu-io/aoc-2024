package io.tohuwabohu.aoc2024.day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {
    private final Pattern pattern;

    public Day03() {
        pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
    }

    public long part1(String fileName) throws FileNotFoundException {
        var bufferedReader = new BufferedReader(new FileReader(fileName));

        return bufferedReader.lines()
                .map(line -> pattern.matcher(line))
                .map(this::sum).reduce(0L, Long::sum);
    }

    private long sum(Matcher matcher) {
        var sum = 0L;

        while (matcher.find()) {
            var result = matcher.toMatchResult();
            var a = Long.parseLong(result.group(1));
            var b = Long.parseLong(result.group(2));

            sum += a * b;
        }

        return sum;
    }
}
