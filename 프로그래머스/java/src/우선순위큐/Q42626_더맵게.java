package 우선순위큐;

import java.util.PriorityQueue;

public class Q42626_더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.add(i);
        }

        while (pq.size() >= 2) {
            if (pq.peek() >= K) {
                return answer;
            }

            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }

        return pq.peek() >= K ? answer : -1; // 최종 pq의 size가 1인 경우 값 따로 확인
    }
}
