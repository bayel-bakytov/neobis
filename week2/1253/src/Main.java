import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String text;
        StringBuilder str = new StringBuilder();
        int step;
        char res;
        for (int i = 0; i < num; i++) {
            text = in.next();
            step = in.nextInt();
            str.append(text);
            int asciCodeA = 65;
            for (int j = 0; j < str.length(); j++) {
                res = str.charAt(j);
                if (res - step < asciCodeA) {
                    res = (char)(res + 26);
                }
                res = (char)(res - step);
                str.setCharAt(j, res);
            }

            System.out.println(str);
            str.delete(0,str.length());
        }
    }
}