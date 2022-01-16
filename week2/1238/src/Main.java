import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String str1;
        String str2;
        int lenStr1 = 0;
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < num; i++) {
            str1 = in.next();
            str2 = in.next();
            lenStr1 = (str1.length() > str2.length()) ? str1.length() : str2.length();
            for (int j = 0; j < lenStr1; j++) {
                if (j < str1.length()) {
                    text.append(str1.charAt(j));
                }
                if (j < str2.length()) {
                    text.append(str2.charAt(j));
                }
            }
            System.out.println(text);
            text.delete(0,text.length());
        }
    }

}