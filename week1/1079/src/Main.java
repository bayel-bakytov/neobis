import java.io.IOException;
import java.text.DecimalFormat;
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