package recursion;

import java.util.Scanner;

public class Factorial {

    static int factorial(int n) {
        if (n > 0) {
            return n - factorial(n - 1);
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("정수를 입력 하세요.");
        int n = stdIn.nextInt();

        System.out.println(n + "! = " + factorial(n));
    }
}
