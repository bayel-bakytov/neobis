import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int temp;
        int[] banknotes = new int[] {100, 50, 20, 10, 5, 2, 1};
        System.out.println(sum);
        for (int i = 0; i < 7; i++) {
            temp = sum / banknotes[i];
            sum = sum % banknotes[i];
            System.out.println(temp + " nota(s) de R$ " + banknotes[i] + ",00");
        }
    }
}