package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] req = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            req[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            int result = binarySearch(arr, req[i], 0, N - 1);
            if (result == -1) {
                System.out.print("no ");
            } else {
                System.out.print("yes ");
            }
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = (start + end) / 2;

            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;

                // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 할인
            else if (arr[mid] > target) end = mid - 1;

                // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1;
        }

        return -1;
    }
}
