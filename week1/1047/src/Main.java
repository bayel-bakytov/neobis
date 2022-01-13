import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
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