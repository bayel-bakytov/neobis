import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String password = in.nextLine();
            boolean isOk = false;
            isOk = checkPassword(password);
            if (isOk) {
                System.out.println("Senha valida.");
            } else {
                System.out.println("Senha invalida.");
            }
        }
    }
    public static boolean checkPassword(String password) {
        int countLoLetter = 0;
        int countUpLetter = 0;
        int countNum = 0;
        int countNoLetNoNum = 0;
        if (password.length() >= 6 && password.length() <= 32) {
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    countUpLetter++;
                }
                if (Character.isLowerCase(password.charAt(i))) {
                    countLoLetter++;
                }
                if(Character.isDigit(password.charAt(i))) {
                    countNum++;
                }
                if(!Character.isLetterOrDigit(password.charAt(i))) {
                    countNoLetNoNum++;
                }
            }
            if (countLoLetter >= 1 &&
                    countNum >= 1 &&
                    countUpLetter >= 1 &&
                    countNoLetNoNum == 0) {
                return true;
            }
        }
        return false;
    }
}