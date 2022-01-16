import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int n;
        int k;
        int survivor;
        for (int i = 1; i <= num; i++) {
            n = in.nextInt();
            k = in.nextInt();
            survivor = checkPeople(n,k);
            System.out.println("Case " + i +": " + survivor);
        }
    }

    public static int checkPeople(int people, int steps) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (int l = 1; l <= people; l++) {
            list.add(l);
        }
        while (people != 1) {
            ++i;
            if (i % steps == 0) {
                people--;
                list.remove(j);
            } else {
                ++j;
                j = j % people;
            }
        }
        return list.get(0);
    }
}