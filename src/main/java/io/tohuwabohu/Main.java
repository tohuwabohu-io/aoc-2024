package io.tohuwabohu;

import io.tohuwabohu.aoc2024.day01.Day01;

public class Main {
    public static void main(String[] args) {
        try {
            Day01 day01 = new Day01();

            System.out.println(day01.part1("src/main/resources/day01.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}