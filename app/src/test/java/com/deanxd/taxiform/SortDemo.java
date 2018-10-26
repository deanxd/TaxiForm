package com.deanxd.taxiform;

import java.util.Arrays;

public class SortDemo {

    public static void bubblingSorting() {
        int[] data = new int[]{1, 2, 5, 7, 8, 9, 4, 9};

        System.out.println(printArray(data));

        for (int i = 0; i < data.length; i++) {
            boolean isSort = false;

            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    isSort = true;
                }
            }

            if (!isSort) {
                break;
            }
        }

        System.out.println(printArray(data));
    }

    public static void insertSorting() {
        int[] data = new int[]{1, 2, 5, 7, 8, 9, 4, 9};

        System.out.println(printArray(data));

        for (int i = 1; i < data.length; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data[j] > value) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }

        System.out.println(printArray(data));
    }

    public static void selectSorting() {
        int[] data = new int[]{1, 2, 7, 6, 5, 7, 8, 9, 4, 9};

        System.out.println(printArray(data));

        for (int i = 0; i < data.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[k]) {
                    k = j;
                }
            }

            if (k != i) {
                int temp = data[i];
                data[i] = data[k];
                data[k] = temp;
            }
        }

        System.out.println(printArray(data));
    }


    public static void mergeSoft() {
        int[] arraySum = new int[10];
        int[] arrayOne = new int[5];
        int[] arrayTwo = new int[5];

//        arraySum = Arrays.binarySearch();

//        Arrays.


    }


    private static String printArray(int[] array) {
        StringBuilder builder = new StringBuilder();
        builder.append("data:");

        if (array != null && array.length > 0) {
            for (int data : array) {
                builder.append(data).append(",");
            }
        }
        return builder.toString();

    }
}
