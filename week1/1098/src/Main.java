public class Main {

    public static void main(String[] args) {

        firstPrint(0,1);
        secondPrint(0.2,1);
        firstPrint(1,2);
        secondPrint(1.2,1);
        firstPrint(2,3);
    }

    public static void firstPrint(int o,int j) {
        for (int i = 1; i <= 3; i++) {
            System.out.println("I=" + o + " J=" + j);
            j++;
        }
    }

    public static void secondPrint(double j, double o) {
        int k = 1;
        for (int i = 0; i < 12; i++) {
            if (k <= 3) {
                System.out.println("I=" + (float)j + " J=" + (float)(o + j));
                o = o + 1;
                k = k + 1;
            } if (k == 4) {
                j = j + 0.2;
                o = 1;
                k = 1;
            }
        }
    }
}