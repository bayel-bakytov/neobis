import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        double dinheiroTotal = leitor.nextDouble();
        int notas = (int) dinheiroTotal;
        int moedas = (int) ((dinheiroTotal - notas) * 100);
        int[] arr = new int[] {100,50,20,10,5,2};
        int[] a = new int[] {50,25,10,5};
        int[] ara = new int[6];
        for (int i = 0; i < 6; i++) {
            ara[i] = notas / arr[i];
            notas -= ara[i] * arr[i];
        }
        System.out.println("NOTAS:");
        System.out.println(ara[0] + " nota(s) de R$ 100.00");
        System.out.println(ara[1] + " nota(s) de R$ 50.00");
        System.out.println(ara[2] + " nota(s) de R$ 20.00");
        System.out.println(ara[3] + " nota(s) de R$ 10.00");
        System.out.println(ara[4] + " nota(s) de R$ 5.00");
        System.out.println(ara[5] + " nota(s) de R$ 2.00");

        for (int i = 0; i < 4; i++) {
            ara[i] = moedas / a[i];
            moedas -= ara[i] * a[i];
        }
        System.out.println("MOEDAS:");
        System.out.println(notas * 1 + " moeda(s) de R$ 1.00");
        System.out.println(ara[0] + " moeda(s) de R$ 0.50");
        System.out.println(ara[1] + " moeda(s) de R$ 0.25");
        System.out.println(ara[2] + " moeda(s) de R$ 0.10");
        System.out.println(ara[3] + " moeda(s) de R$ 0.05");
        System.out.println(moedas + " moeda(s) de R$ 0.01");
    }

}