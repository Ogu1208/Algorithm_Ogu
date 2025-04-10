package 그리디;

import java.util.Scanner;

public class 동전_0 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coinTypes = new int[N];

        for (int i = 0; i < N; i++) {
            coinTypes[i] = sc.nextInt();
        }

        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (K >= coinTypes[i]) {
                count += K / coinTypes[i];
                K %= coinTypes[i];
            } else {
                continue;
            }
        }

        System.out.println( count);
    }
}
