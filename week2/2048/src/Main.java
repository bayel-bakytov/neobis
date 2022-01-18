import java.util.Scanner;

public class Main {

    static int[][] desktop = new int[4][4];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int move;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop.length; j++) {
                desktop[i][j] = in.nextInt();
            }
        }

        move = in.nextInt();
        switch(move) {
            case 0:
                moveToLeft(desktop);
                break;
            case 1:
                moveToUp(desktop);
                break;
            case 2:
                moveToRight(desktop);
                break;
            case 3:
                moveToDown(desktop);
                break;
            default:
                break;
        }

        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop.length; j++) {
                System.out.print(desktop[i][j] + " ") ;
            }
            System.out.println();
        }
    }
    public static void sortZeroToLeft (int[][] desktop) {
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop.length; j++) {
                for (int k = 0; k < desktop.length - 1; k++) {
                    if (desktop[j][k] == 0) {
                        desktop[j][k] = desktop[j][k+1];
                        desktop[j][k+1] = 0;
                    }
                }
            }
        }
    }

    public static void moveToLeft(int[][] dekstop) {
        sortZeroToLeft(desktop);
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop.length - 1; j++) {
                if (desktop[i][j] == desktop[i][j + 1]) {
                    desktop[i][j] = desktop[i][j + 1] * 2;
                    desktop[i][j + 1] = 0;
                }
            }
        }
        sortZeroToLeft(desktop);
    }

    public static void sortZeroToUp(int[][] desktop) {
        for (int k = 0; k < desktop.length; k++) {
            for (int j = 0; j < desktop.length; j++) {
                for (int i = 0; i < desktop.length - 1; i++) {
                    if (desktop[i][j] == 0) {
                        desktop[i][j] = desktop[i + 1][j];
                        desktop[i + 1][j] = 0;
                    }
                }
            }
        }
    }

    public static void moveToUp(int[][] desktop) {
        sortZeroToUp(desktop);
        for (int j = 0; j < desktop.length; j++) {
            for (int i = 0; i < desktop.length - 1; i++ ) {
                if (desktop[i][j] == desktop[i + 1][j]) {
                    desktop[i][j] = desktop[i + 1][j] * 2;
                    desktop[i + 1][j] = 0;
                }
            }
        }
        sortZeroToUp(desktop);
    }

    public static void sortZeroToRight(int[][] desktop) {
        for (int k = 0; k < desktop.length; k++) {
            for (int i = 0; i < desktop.length; i++) {
                for (int j = desktop.length - 1; j > 0; j--) {
                    if (desktop[i][j] == 0) {
                        desktop[i][j] = desktop[i][j-1];
                        desktop[i][j-1] = 0;
                    }
                }
            }
        }
    }

    public static void moveToRight(int[][] desktop) {
        sortZeroToRight(desktop);
        for (int i = 0; i < desktop.length; i++) {
            for (int j = desktop.length - 1; j > 0; j--) {
                if (desktop[i][j] == desktop[i][j - 1]) {
                    desktop[i][j] = desktop[i][j - 1] * 2;
                    desktop[i][j - 1] = 0;
                }
            }
        }
        sortZeroToRight(desktop);
    }

    public static void sortZeroToDown(int[][] desktop) {
        for (int k = 0; k < 4; k++) {
            for (int j = 0; j < 4; j++) {
                for (int i = 1; i < 4; i++) {
                    if (desktop[i][j] == 0) {
                        desktop[i][j] = desktop[i - 1][j];
                        desktop[i - 1][j] = 0;
                    }
                }
            }
        }
    }

    public static void moveToDown(int[][] desktop) {
        sortZeroToDown(desktop);
        for (int j = 3; j >= 0; j--) {
            for (int i = 3; i >= 1; i--) {
                if (desktop[i][j] == desktop[i - 1][j]) {
                    desktop[i][j] = desktop[i - 1][j] * 2;
                    desktop[i - 1][j] = 0;
                }
            }
        }
        sortZeroToDown(desktop);
    }

}
