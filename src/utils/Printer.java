package utils;

public class Printer {

    public static void print(int[] arr) {
        print(arr, "");
    }

    public static void print(int[] arr, String delimiter) {
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(delimiter + " ");
        }
    }
}
