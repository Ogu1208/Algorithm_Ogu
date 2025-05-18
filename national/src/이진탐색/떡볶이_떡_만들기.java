package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떡볶이_떡_만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = (int) 1e9; // 성능을 위해 Arrays.stream(arr).max().getAsInt() 보다 1e9로 설정
        int result = 0;

        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if (mid < arr[i])
                    total += arr[i] - mid;
            }

            // 떡의 양이 부족한 경우 더 많이 자르기 (왼쪽 탐색)
            if (total < M) {
                end = mid - 1;
            } else { // 떡의 양이 충분한 경우 덜 자르기 (오른쪽 탐색)
                result = mid; // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
