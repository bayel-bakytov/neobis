import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num;
        boolean isPrime = false;
        for (int i = 0; i < n; i++) {
            num = in.nextInt();
            isPrime = checkPrimeNum(num);
            if (isPrime) {
                System.out.println(num + " eh primo");
            } else {
                System.out.println(num + " nao eh primo");
            }
        }
    }
    public static boolean checkPrimeNum(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}