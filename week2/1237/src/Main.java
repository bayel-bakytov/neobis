import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int substr;
        while (in.hasNext()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            substr = findMaxSubstr(str1,str2);
            System.out.println(substr);
        }

    }

    public static int findMaxSubstr(String str1, String str2) {
        int count = 0;
        int k = 0;
        int maxSubstr = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                count = 0;
                if (str1.charAt(i) == str2.charAt(j)) {
                    k = 0;
                    while (k + i < str1.length() && k + j < str2.length()) {
                        if (str1.charAt(k + i) != str2.charAt(k + j)) {
                            break;
                        }
                        count = count + 1;
                        k = k + 1;
                    }
                    if (maxSubstr < count) {
                        maxSubstr = count;
                    }
                }
            }
        }
        return maxSubstr;
    }
}