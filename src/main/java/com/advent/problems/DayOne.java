package com.advent.problems;

import com.advent.helpers.FileReaderHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DayOne {

    private static int calorieCount = 0;

    public static void main(String[] args)  {
        var list = FileReaderHelper.convertFileToList("elfcalories.txt");
        var elfList = new ArrayList<Integer>();
        for (String st : list) {
            if (Objects.isNull(st) || st.isBlank()) {
                elfList.add(calorieCount);
                resetCalorieCount();
                continue;
            }
            calorieCount += Integer.parseInt(st);
        }
        System.out.println("Part 1 - Total calories: " + Collections.max(elfList));
        System.out.println("Part 2 - Total calories of top 3 elves: " + calculateSumOfTop3Elves(elfList));
        elfList.sort(Collections.reverseOrder());
    }

    private static void resetCalorieCount() {
        calorieCount = 0;
    }

    private static int calculateSumOfTop3Elves(List<Integer> elfList) {
        elfList.sort(Collections.reverseOrder());
        return elfList.subList(0, 3).stream().mapToInt(Integer::intValue).sum();
    }
 }
