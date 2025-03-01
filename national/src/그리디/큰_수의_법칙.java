package 그리디;

import java.util.Arrays;
import java.util.Scanner;

public class 큰_수의_법칙 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 배열의 크기
        int m = sc.nextInt(); // 숫자가 더해지는 횟수
        int k = sc.nextInt(); // 연속해서 더할 수 있는 횟수

        int[] arr = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수


        // 굳이 케이스를 나눌 필요가 없는 것이었음
//        if (first == second) {
//            result = m * first;
//        } else {
//            result = ((first * k + second) * (m / (k + 1))) + (first * (m % (k + 1)));
//        }

        // 가장 큰 수가 더해지는 횟수
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        result = first * cnt; // 가장 큰 수 더하기
        result += second * (m - cnt); // 두 번째로 큰 수 더하기


        System.out.println(result);
    }
}
