import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int num;
        boolean checkNum = false;
        for (int i = 0; i < n; i++) {
            num = in.nextInt();
            checkNum = searchPerfectNum(num);
            if (checkNum) {
                System.out.println(num + " eh perfeito");
            } else {
                System.out.println(num + " nao eh perfeito");
            }
        }
    }

    public static boolean searchPerfectNum(int num) {
        int res = 0;
        for (int i = 0; i < num; i++){
            res = res + i;
            if (res == num) {
                return true;
            }
        }
        return false;
    }
}