
public class MissingNumber {
    public static void main(String[] args) {
        int[] input = new int[] { 1, 2, 4, 6, 3, 7, 8 };
        System.out.println(findMissingNumber(input));
    }

    public static int findMissingNumber(int[] elements) {
        int result = 1;
        for (int i = 2; i <= elements.length + 1; i++) {
            result += i - elements[i - 2];
        }
        return result;
    }
}
