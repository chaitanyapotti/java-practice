import java.util.Arrays;

/*

Move 1's to the right always.
Everything will be ordered automatically

*/

public class ArrayNumberOrdering {
    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
        sortArray(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int[] sortArray(int[] input) {
        int left = 0;
        int right = input.length - 1;
        while (left < right) {
            if (input[left] == 1) {
                int temp = input[right];
                input[right] = input[left];
                input[left] = temp;
                right--;
            } else {
                left++;
            }
        }
        return input;
    }
}
