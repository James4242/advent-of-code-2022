package com.advent.problems;

import com.advent.helpers.FileReaderHelper;

import java.util.ArrayList;
import java.util.Collections;
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
        System.out.println("Total calories: " + Collections.max(elfList));
    }

    private static void resetCalorieCount() {
        calorieCount = 0;
    }
}
