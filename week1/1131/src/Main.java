import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;
        Scanner in = new Scanner(System.in);
        int inter = 0;
        int gremio = 0;
        int empates = 0;
        int counter = 0;
        while (flag) {
            int team1 = in.nextInt();
            int team2 = in.nextInt();
            if (team1 > team2) {
                inter = inter + 1;
            } else if (team1 < team2) {
                gremio = gremio + 1;
            } else {
                empates = empates + 1;
            }
            counter = counter + 1;
            int newMatch = in.nextInt();
            if (newMatch == 2) {
                flag = false;
            }
        }
        for (int i = 0; i < counter; i++) {
            System.out.println("Novo grenal (1-sim 2-nao)");
        }
        System.out.println(counter + " grenais");
        System.out.println("Inter:" + inter);
        System.out.println("Gremio:" + gremio);
        System.out.println("Empates:" + empates);
        if (inter > gremio) {
            System.out.println("Inter venceu mais");
        } else if (inter < gremio) {
            System.out.println("Gremio venceu mais");
        } else {
            System.out.println("Não houve vencedor");
        }

    }

}