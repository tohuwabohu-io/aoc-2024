package io.tohuwabohu;

import io.tohuwabohu.aoc2024.day01.Day01;
import io.tohuwabohu.aoc2024.day02.Day02;

public class Main {
    public static void main(String[] args) {
        System.out.println("Advent of Code 2024");
        System.out.println("===================");

        try {
            System.out.println("----- Day 01 ------");

            Day01 day01 = new Day01();

            System.out.print("Part 01:\t");
            System.out.println(day01.part1("src/main/resources/day01.txt"));
            System.out.print("Part 02:\t");
            System.out.println(day01.part2("src/main/resources/day01.txt"));

            System.out.println("----- Day 02 ------");

            Day02 day02 = new Day02();

            System.out.print("Part 01:\t");
            System.out.println(day02.part1("src/main/resources/day02.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}