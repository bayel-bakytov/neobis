import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        float n1, n2, n3;
        DecimalFormat f = new DecimalFormat("#.0");
        for (int i = 0; i < num; i++) {
            n1 = in.nextFloat() * 2;
            n2 = in.nextFloat() * 3;
            n3 = in.nextFloat() * 5;
            System.out.println(f.format((n1 + n2 + n3) / 10));
        }
    }

}