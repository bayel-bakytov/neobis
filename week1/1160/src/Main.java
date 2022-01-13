import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int pa,pb;
        double g1, g2;
        int countYear = 0;
        boolean isA = true;
        for (int i = 0; i < num; i++) {
            pa = in.nextInt();
            pb = in.nextInt();
            g1 = in.nextDouble();
            g2 = in.nextDouble();
            countYear = 0;
            while (pb >= pa) {
                pa += (int) ((pa * g1) / 100);
                pb += (int) ((pb * g2) / 100);
                countYear = countYear + 1;
                if (countYear > 100) {
                    System.out.println("Mais de 1 seculo.");
                    break;
                }
            }

            if (countYear <= 100) {
                System.out.println(countYear + " anos.");
            }

        }
    }
}