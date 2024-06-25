package class1.bronze_10818;

/**
 * 걸린 시간 : 1748ms
 */

import java.util.Scanner;

public class bronze3_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = 1000000;
        int max = -1000000;

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if(a < min)
                min = a;
            if (a > max)
                max = a;
        }

        System.out.printf("%d %d", min, max);

    }
}
