import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        double A = in.nextDouble();
        double B = in.nextDouble();
        double C = in.nextDouble();
        if (A >= B + C || B >= A + C || C >= B + A) {
            System.out.println("NAO FORMA TRIANGULO");
        } else if (Math.pow(A, 2) == Math.pow(B,2) + Math.pow(C,2) || Math.pow(B, 2) == Math.pow(A,2) + Math.pow(C,2) || Math.pow(C, 2) == Math.pow(B,2) + Math.pow(A,2)) {
            System.out.println("TRIANGULO RETANGULO");
        } else if (Math.pow(A, 2) > Math.pow(B,2) + Math.pow(C,2) || Math.pow(B, 2) > Math.pow(A,2) + Math.pow(C,2) || Math.pow(C, 2) > Math.pow(B,2) + Math.pow(A,2)) {
            System.out.println("TRIANGULO OBTUSANGULO");
        } else if (Math.pow(A, 2) < Math.pow(B,2) + Math.pow(C,2) || Math.pow(B, 2) < Math.pow(A,2) + Math.pow(C,2) || Math.pow(C, 2) < Math.pow(B,2) + Math.pow(A,2)) {
            System.out.println("TRIANGULO ACUTANGULO");
        }
        if (A == B && B == C && C == A) {
            System.out.println("TRIANGULO EQUILATERO");
        } else if ((A == B && A != C)  || (A == C && A != B) || (B == C && B != A)) {
            System.out.println("TRIANGULO ISOSCELES");
        }
    }

}