package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q12015_가장긴증가하는부분수열2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> LIS = new ArrayList<>();

        LIS.add(arr[0]);

        for (int key : arr) {
            if (LIS.get(LIS.size() - 1) < key)
                LIS.add(key);
            else {
                int low = 0;
                int high = LIS.size() - 1;
                while (low < high) {
                    int mid = (low + high) / 2;
                    if (LIS.get(mid) < key) low = mid + 1;
                    else high = mid;
                }
            }
        }

        /* Collections.binarySearch 라이브러리 사용
        for (int num : arr) {
            // lis에서 num이 들어갈 위치 찾기
            int idx = Collections.binarySearch(LIS, num);

            // Java의 binarySearch는 값이 없으면 삽입 위치를 -(삽입위치 + 1) 로 리턴
            if (idx < 0) {
                idx = -(idx + 1);
            }

            // 삽입 위치가 맨 끝이면 새로운 값을 추가
            if (idx == LIS.size()) {
                LIS.add(num);
            } else { // 중간이면 그 자리에 덮어쓰기 (길이를 유지하면서 수열을 더 작게 만들어서 나중에 더 좋은 결과 가능하게 함)
                LIS.set(idx, num);
            }
        }
         */


        System.out.println(LIS.size());
    }
}
