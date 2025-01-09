package task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.OptionalInt;

public class task4 {
    public static void main(String[] args) throws IOException {
        BufferedReader circle = new BufferedReader(new FileReader(args[0]));
        ArrayList<Integer> arr = new ArrayList<>();
        String buff = circle.readLine();
        while (buff != null) {
            arr.add(Integer.parseInt(buff));
            buff = circle.readLine();
        }
        System.out.println(letsMakeTheSame(arr));
    }

    public static int letsMakeTheSame(ArrayList<Integer> arr) {
        int res = 0;
        int average = arr.stream().mapToInt(Integer::intValue).sum() / arr.size();
        //System.out.println(average);
        long countLess = arr.stream().filter(number -> number < average + 0.5).count();
        //System.out.println(countLess);
        long countMore = arr.stream().filter(number -> number > average + 0.5).count();
        //System.out.println(countMore);
        if (countMore == countLess ) {
            for (Integer integer : arr) {
                res += Math.abs(integer - average);
            }
            return res;
        } else if (countMore > countLess) {
            OptionalInt buff = arr.stream().filter(number -> number >= average).mapToInt(Integer::intValue).min();
            for (Integer integer : arr) {
                res += Math.abs(integer - buff.orElse(0));
            }
            return res;
        } else {
            OptionalInt buff = arr.stream().filter(number -> number <= average).mapToInt(Integer::intValue).max();
            for (Integer integer : arr) {
                res += Math.abs(integer - buff.orElse(0));
            }
            return res;
        }
    }
}
