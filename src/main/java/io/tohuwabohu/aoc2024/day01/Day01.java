package io.tohuwabohu.aoc2024.day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day01 {
    public long part1(String fileName) throws FileNotFoundException {
        var bufferedReader = new BufferedReader(new FileReader(fileName));

        var splitLists = bufferedReader.lines()
                .map(line -> line.split(" {3}"))
                .collect(Collectors.teeing(
                        Collectors.mapping(split -> Integer.parseInt(split[0]), Collectors.toList()),
                        Collectors.mapping(split -> Integer.parseInt(split[1]), Collectors.toList()),
                        List::of
                ));

        var leftList = splitLists.get(0).stream().sorted().toList();
        var rightList = splitLists.get(1).stream().sorted().toList();

        var result = 0;

        for (int i = 0; i < leftList.size(); i++) {
            result += Math.abs(leftList.get(i) - rightList.get(i));
        }

        return result;
    }

    public long part2(String fileName) throws FileNotFoundException {
        var bufferedReader = new BufferedReader(new FileReader(fileName));

        var splitLists = bufferedReader.lines()
                .map(line -> line.split(" {3}"))
                .collect(Collectors.teeing(
                        Collectors.mapping(split -> Integer.parseInt(split[0]), Collectors.toList()),
                        Collectors.mapping(split -> Integer.parseInt(split[1]), Collectors.toList()),
                        List::of
                ));

        var leftList = new ArrayList<>(splitLists.get(0).stream().sorted().toList());

        var rightList = new ArrayList<>(splitLists.get(1).stream().sorted().toList());
        rightList.retainAll(leftList);

        leftList.retainAll(rightList);

        var result = 0;

        for (Integer search : leftList) {
            result += search * (int) rightList.stream().filter(rightItem -> Objects.equals(rightItem, search)).count();
        }

        return result;
    }
}
