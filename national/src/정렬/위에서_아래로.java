package 정렬;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 위에서_아래로 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
