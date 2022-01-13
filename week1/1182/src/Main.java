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
        int numCol = in.nextInt();
        char symbol = in.next().charAt(0);
        symbol = Character.toUpperCase(symbol);
        double arr[][] = new double[12][12];
        double sum = 0;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                arr[i][j] = in.nextDouble();
            }
            sum = sum + arr[i][numCol];
        }
        if (symbol == 'M') {
            double median = sum / 12;
            median = Math.round(median * 10.0) / 10.0;
            System.out.println(median);
        }
        else if (symbol == 'S'){
            System.out.println(sum);
        }
    }


}