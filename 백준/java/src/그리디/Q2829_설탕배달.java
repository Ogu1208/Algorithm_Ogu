package 그리디;

import java.util.Scanner;

public class Q2829_설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;


        while (true) {
            if (N < 0) {
                System.out.println(-1);
                break;
            }

            if (N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                break;
            } else {
                N -= 3;
                count++;
            }
        }
    }
}
