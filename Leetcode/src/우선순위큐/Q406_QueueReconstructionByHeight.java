package 우선순위큐;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q406_QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // 우선 키를 기준으로 내림차순, k를 기준으로 오름차순 우선순위 큐 구성
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);

        pq.addAll(Arrays.asList(people));

        List<int[]> result = new ArrayList<>();

        // 우선순위 큐가 빌 때까지 반복
        while(!pq.isEmpty()) {
            int[] person = pq.poll();
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][2]);
    }
}
