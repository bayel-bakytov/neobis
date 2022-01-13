import java.io.IOException;
import java.util.Scanner;
/**
 * IMPORTANT:
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {

    public static void main(String[] args) throws IOException {
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