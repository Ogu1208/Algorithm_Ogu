package class1;

import java.util.Scanner;

/**
 * 시간 : 212ms
 */

public class bronze3_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int max = Integer.MIN_VALUE;
        int n = -1;

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max = arr[i];
                n = i;
            }
        }

        System.out.println(max);
        System.out.println(n+1);
    }
}
