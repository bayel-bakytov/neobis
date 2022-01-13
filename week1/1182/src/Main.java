import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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