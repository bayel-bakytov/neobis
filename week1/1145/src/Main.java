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
        int x = in.nextInt();
        int y = in.nextInt();
        int counter = 0;
        for (int i = 1; i <= y; i++) {
            if (counter == x-1) {
                System.out.println(i);
                counter = 0;
            } else if (counter != x - 1) {
                System.out.print(i + " ");
                ++counter;
            }
        }
    }

}