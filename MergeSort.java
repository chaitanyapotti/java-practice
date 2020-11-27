import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 12, 11, 13, 5, 6, 7 };
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void sort(int[] arr) {
        _sort(arr, 0, arr.length - 1);
    }

    private static void _sort(int[] arr, int l, int r) {
        if (l < r) {
            // middle
            int m = (l + r) / 2;
            _sort(arr, l, m);
            _sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        // size of left half
        int n1 = m - l + 1; // includes middle element at m
        int n2 = r - m;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[l + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
