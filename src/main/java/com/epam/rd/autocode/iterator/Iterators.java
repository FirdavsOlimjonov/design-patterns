package com.epam.rd.autocode.iterator;

import java.util.*;

class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array){
        int[] ints = new int[array.length * 2];
        int k = 0;
        for (int j : array) {
            ints[k] = j;
            ints[k + 1] = j;
            k = k + 2;
        }
        return Arrays.stream(ints).iterator();
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {

        int[] ints = new int[array.length * 3];
        int k = 0;
        for (int j : array) {
            ints[k] = j;
            ints[k + 1] = j;
            ints[k + 2] = j;
            k = k + 3;
        }
        return Arrays.stream(ints).iterator();
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        int[] ints = new int[array.length * 5];
        int k = 0;
        for (int j : array) {
            ints[k] = j;
            ints[k + 1] = j;
            ints[k + 2] = j;
            ints[k + 3] = j;
            ints[k + 4] = j;
            k = k + 5;
        }
        return Arrays.stream(ints).iterator();
    }

    public static Iterable<String> table(String[] columns, int[] rows){

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < columns.length; i++) {
            for (int k = 0; k < rows.length; k++) {
                arrayList.add(columns[i]+rows[k]);
            }
        }
        return arrayList;
    }



}

