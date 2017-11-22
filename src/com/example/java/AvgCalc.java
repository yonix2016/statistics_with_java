package com.example.java;

import java.util.*;

/**
 * Created by yonasmenghis on 11/21/17.
 */
public class AvgCalc {

    public static final String TRIMMED_MEAN = "trimmedmean";
    public static final String MEAN = "mean";

    private static float mean(List<Float> numbers, boolean trimmed){

        float total = 0;

        if (trimmed){

            // Before trimming we sort the numbers in an increasing order
            Collections.sort(numbers, new Comparator<Float>() {
                @Override
                public int compare(Float o1, Float o2) {
                    return o1.compareTo(o2);
                }
            });


            TextIO.putln(String.format("Trimming: %f", numbers.get(0)));
            // Removing the least number
            numbers.remove(0);
            TextIO.putln(String.format("Trimming: %f", numbers.get(numbers.size()-1)));
            // Removing the largest number
            numbers.remove(numbers.size()-1);
        }


        for (float num :
                numbers) {
            total += num/numbers.size();
            System.out.println(String.format("Current mean %s", String.valueOf(total/numbers.size())));
        }

        return total;

    }


    public static void main(String[] args) {

        String instruction = "Input numbers separated by commas and press ENTER: ";
        String choose = "type " + MEAN + " or " + TRIMMED_MEAN + " and press ENTER: ";


        // Asking the users to enter comma separated numbers
        TextIO.putln(instruction);
        String input = TextIO.getlnString();

        // Changing the input into an array of strings containing the numbers
        String[] inputNums = input.split(",");


        // Converting the string of numbers to a list of Float
        ArrayList<Float> numbers = new ArrayList<>();
        for (int i = 0; i < inputNums.length; i++) {
            numbers.add(Float.valueOf(inputNums[i]));
        }

        // Asking the user to choose between trimmedmean or just mean
        TextIO.putln(choose);
        String trimmedOrNot = TextIO.getlnString();
        boolean trimmed = trimmedOrNot.equalsIgnoreCase(TRIMMED_MEAN);
        mean(numbers, trimmed);
    }

}
