public class AtoI {
    public static void main(String[] args) {
        System.out.println(atoi("259"));
        System.out.println(atoi("12637273827383784873874873743"));
    }

    public static int atoi(String input) {
        if (input == null) {
            return 0;
        }
        // trim white spaces
        input = input.trim();

        if (input.equals("")) return 0;

        char flag = '+';
        int index = 0;
        if (input.charAt(0) == '-') {
            flag = '-';
            index = 1;
        } else if (input.charAt(0) == '+') {
            index = 1;
        }

        double result = 0;

        while (input.length() > index && input.charAt(index) >= '0' && input.charAt(index) <= '9') {
            result = result * 10 + (input.charAt(index) - '0');
            index++;
        }

        if (flag == '-') {
            result = -result;
        }

        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) (result);

    }
}
