package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920_수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int result = binarySearch(arr, num, 0, N - 1);

            System.out.print(result + " ");
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) return 1;

            else if (arr[mid] < target) start = mid + 1;

            else end = mid - 1;
        }

        return 0;
    }
}


