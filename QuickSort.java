import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 12, 11, 13, 5, 6, 7 };
        sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void sort(int[] arr) {
        _sort(arr, 0, arr.length - 1);
    }

    private static void _sort(int[] arr, int l, int h) {
        if (l < h) {
            // middle
            int pi = partition(arr, l, h);
            _sort(arr, l, pi - 1);
            _sort(arr, pi + 1, h);
        }
    }

    private static int partition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[h] = temp;
        return i + 1;
    }

}
