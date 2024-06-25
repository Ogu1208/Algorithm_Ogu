package class1.bronze_11720;

import java.util.Scanner;

/**
 * Scanner + String.charAt() - '0'
 * 시간 : 228ms
 */

public class bronze_11720_way2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String str = sc.next();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += str.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}
