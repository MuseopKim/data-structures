package Recursion;

import java.util.Scanner;

public class EuclideanMethodOfMutualDivision {

    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대 공약수 구하기");

        System.out.println("정수 x 입력 : ");
        int x = stdIn.nextInt();

        System.out.println("정수 y 입력 : ");
        int y = stdIn.nextInt();

        System.out.println("x, y의 최대 공약수 : " + gcd(x, y));
    }
}
