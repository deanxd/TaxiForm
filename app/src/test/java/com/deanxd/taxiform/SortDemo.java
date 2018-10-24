package com.deanxd.taxiform;

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
            for (int j = 0; j < i; j++) {
                if(data[i] < data[j]){
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }

        System.out.println(printArray(data));
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
