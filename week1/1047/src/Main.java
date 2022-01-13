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
        int beginHour = in.nextInt();
        int beginMinut = in.nextInt();
        int endHour = in.nextInt();
        int endMinut = in.nextInt();

        int duration = ((endHour * 60) + endMinut) - ((beginHour * 60) + beginMinut);

        if (duration <= 0) {
            duration = duration + 24 * 60;
        }
        int resMinut = duration % 60;
        int resHour = duration / 60;
        System.out.println("O JOGO DUROU " + resHour + " HORA(S) E " + resMinut + " MINUTO(S)");
    }

}