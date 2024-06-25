package class1.bronze_10818;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 기존의 방법이 굉장히 시간이 오래걸려 Arrays를 사용한 방법이다.
 * 걸린 시간 : 2512ms
 */
public class bronze_10818_way2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        System.out.printf("%d %d", arr[0], arr[n-1]);
    }
}
