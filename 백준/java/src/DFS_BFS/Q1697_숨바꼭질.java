package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1697_숨바꼭질 {

    static int[] map = new int[100001];
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
        System.out.println(map[K]);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) break;

            int plus1 = current + 1; // 앞으로 한칸
            int minus1 = current - 1; // 뒤로 한칸
            int twoTimes = current * 2; // 2*X 의 위치로 순간이동

            // 유효한 좌표이고 방문한 적이 없으면
            // map에 시간 기록(방문처리)
            if (plus1 <= 100000 && map[plus1] == 0) {
                queue.offer(plus1);
                map[plus1] = map[current] + 1;
            }
            if (minus1 >= 0 && map[minus1] == 0) {
                queue.offer(minus1);
                map[minus1] = map[current] + 1;
            }
            if (twoTimes <= 100000 &&  map[twoTimes] == 0) {
                queue.offer(twoTimes);
                map[twoTimes] = map[current] + 1;
            }
        }
    }
}
