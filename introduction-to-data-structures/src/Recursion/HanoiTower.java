package Recursion;

import java.util.Scanner;

public class HanoiTower {

    static void move(int rest, int from, int to) {
        if (rest > 1) {
            move(rest - 1, from, 6 - from - to);
        }

        System.out.println("원반 [" + rest + "]을 " + from + "기둥에서 " + to + "기둥으로 옮겼습니다.");

        if (rest > 1) {
            move(rest - 1, 6 - from - to, to);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.println("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);
    }
}
