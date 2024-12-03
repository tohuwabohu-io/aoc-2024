package io.tohuwabohu.aoc2024.day03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

    public long part1(String fileName) throws FileNotFoundException {
        var bufferedReader = new BufferedReader(new FileReader(fileName));
        var pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");

        return bufferedReader.lines()
                .map(pattern::matcher)
                .map(this::sum)
                .reduce(0L, Long::sum);
    }

    public long part2(String fileName) throws FileNotFoundException {
        var bufferedReader = new BufferedReader(new FileReader(fileName));
        var pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)|don't\\(\\)|do\\(\\)");

        return (long) bufferedReader.lines()
                .map(pattern::matcher)
                .reduce(new Object[]{0L, Boolean.TRUE}, // hacky custom leftFold
                        (acc, matcher) -> {
                            acc[0] = (Long) acc[0] + conditionalSum(matcher, acc);
                            return acc;
                        },
                        (acc1, acc2) -> acc1)
                [0];

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

    private long conditionalSum(Matcher matcher, Object[] state) {
        var sum = 0L;
        boolean apply = (Boolean) state[1];

        while (matcher.find()) {
            switch (matcher.group()) {
                case "do()": apply = true; break;
                case "don't()": apply = false; break;
                default: if (apply) {
                    sum += Long.parseLong(matcher.group(1)) * Long.parseLong(matcher.group(2));
                }
            }
        }

        state[1] = apply;

        return sum;
    }
}
