import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.next().toLowerCase();
        String countL = "";
        String countR = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a'
                    || text.charAt(i) == 'e'
                    || text.charAt(i) == 'i'
                    || text.charAt(i) == 'o'
                    || text.charAt(i) == 'u') {
                countL = countL + text.charAt(i);
            }
        }
        for (int i = text.length()-1; i >= 0; i--) {
            if (text.charAt(i) == 'a'
                    || text.charAt(i) == 'e'
                    || text.charAt(i) == 'i'
                    || text.charAt(i) == 'o'
                    || text.charAt(i) == 'u') {
                countR = countR + text.charAt(i);
            }
        }
        if (countL.equals(countR)) {
            System.out.println('S');
        } else {
            System.out.println('N');
        }
    }

}