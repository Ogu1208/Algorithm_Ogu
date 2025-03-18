package 그리디;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q621_TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        // 1. 각 태스크의 빈도를 저장할 배열을 생성 (A-Z까지 총 26개)
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++; // 각 태스크의 등장 횟수를 증가
        }

        // 2. 태스크 빈도수를 정렬 (오름차순 정렬됨)
        Arrays.sort(count);

        // 3. 가장 많이 등장한 태스크의 빈도수 (즉, 최빈값 찾기)
        int maxFreq = count[25]; // 가장 빈도가 높은 태스크

        // 4. "idle slot" 계산 (최악의 경우 필요한 idle 개수)
        // 예: A__A__A (A 사이에 최소한 n개의 간격 필요)
        int idle = (maxFreq - 1) * n;

        // 5. 다른 태스크들을 idle slot에 배치하여 빈 공간을 채움
        // 빈도가 높은 태스크부터 시작하여 idle slot을 줄임
        for (int i = 24; i >= 0 && count[i] > 0; i--) {
            // 각 태스크는 최대 (maxFreq - 1) 만큼 idle을 줄일 수 있음
            idle -= Math.min(maxFreq - 1, count[i]);
        }

        // 6. idle 값이 음수가 될 수도 있음 (즉, idle이 필요 없는 경우)
        idle = Math.max(0, idle);

        // 7. 전체 작업 수 + 필요한 idle 개수를 더한 값이 최소 CPU 사이클
        return tasks.length + idle;
    }
}
