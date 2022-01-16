import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in .nextInt();
        long arr[] = new long[num];
        long newArr[] = new long[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in .nextInt();
        }
        for (int i = 0; i < num; i++) {
            newArr[i] = fib(arr[i]);
            System.out.println("Fib(" + arr[i] + ")" + " = " + newArr[i]);
        }
    }

    public static long fib(long n) {
        long f[] = new long[100];
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[(int) n];
    }
}