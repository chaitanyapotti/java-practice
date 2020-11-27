public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        System.out.println(fibonacci2(10));
        System.out.println(fib(10));
    }

    public static int fibonacci(int input) {
        if (input == 0)
            return 0;
        if (input == 1)
            return 1;
        return fibonacci(input - 1) + fibonacci(input - 2);
    }

    public static int fibonacci2(int input) {
        if (input == 0)
            return 0;
        if (input == 1)
            return 1;
        int first = 1;
        int second = 0;
        int fib = 0;
        for (int i = 2; i <= input; i++) {
            fib = first + second;
            second = first;
            first = fib;
        }
        return fib;
    }

    public static int fib(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }
}
