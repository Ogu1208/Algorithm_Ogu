package 시뮬레이션_구현_완전탐색;

import java.util.Scanner;

public class 왕실의나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String point = sc.nextLine();
        int result = 0;

        int x = point.charAt(0) - 'a';
        int y = point.charAt(1) - '0';

//        System.out.println("x = " + x + "y = " + y);

        int[] dx = {-2, -2, 2, 2, 1, -1, 1, -1};
        int[] dy = {-1, 1, -1, 1, 2, 2, -2, -2};

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx <= 8 && ny <= 8)  {
//                System.out.println("nx = " + nx + ", ny = " + ny);
                result++;
            }
        }

        System.out.println(result);
    }
}
