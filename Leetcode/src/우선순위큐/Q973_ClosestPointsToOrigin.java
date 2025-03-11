package 우선순위큐;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q973_ClosestPointsToOrigin {

    /**
     * 내 풀이, 걸린 시간 : 42ms
     * 느린 이유 : Comparator가 호출될 때마다 Math.pow() 연산을 반복적으로 수행하기 때문에 비효율적
     */
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
//        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->
//                Double.compare(
//                        (Math.pow(o1[0], 2) + Math.pow(o1[1], 2)),
//                        (Math.pow(o2[0], 2) + Math.pow(o2[1], 2))
//                ));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> (Math.pow(o[0], 2) + Math.pow(o[1], 2))));

        Collections.addAll(pq, points);

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}
