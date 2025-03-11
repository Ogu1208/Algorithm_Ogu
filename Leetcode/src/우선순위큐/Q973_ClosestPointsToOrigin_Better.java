package 우선순위큐;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 좀 더 나은 풀이, 걸린 시간 : 30ms
 * 빠른 이유 : 처음 딱 한번 distance를 계산하여 저장해두고, Comparator로 해당 값만 비교하면 되기 때문에 더 빨랐던 것
 */
public class Q973_ClosestPointsToOrigin_Better {
    private class Point {
        int x;
        int y;
        double distance;

        public Point(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(point -> point.distance));
        for (int i = 0; i < points.length; i++) {
            pq.offer(new Point(points[i][0], points[i][1], Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2)));
        }

        for (int i = 0; i < k; i++) {
            Point p = pq.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }

        return result;
    }
}
