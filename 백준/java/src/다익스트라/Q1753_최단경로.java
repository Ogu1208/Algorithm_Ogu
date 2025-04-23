package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 무방향 그래프, 양의 가중치가 주어지고,
 * 시작점에서 다른 모든 정점으로부터의 최단 거리를 구하는 문제이므로
 * 다익스트라 알고리즘으로 풀이할 수 있다.
 */
public class Q1753_최단경로 {
    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static int INF = 100_100_100;
    static List<Node>[] lists;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        Arrays.fill(distance, INF); // 거리 INF로 초기화

        lists = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            lists[i] = new ArrayList<>();
        }

        // 리스트에 그래프 정보 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new Node(end, weight));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if(distance[i] != INF) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작점 추가
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            // 큐에서 거리가 가장 작은 원소 선택
            Node curNode = pq.poll();

            // 현재 큐에서 꺼낸 거리(curNode.weight)가 최신 거리 정보(distance[curNode.end])와 다르면,
            // 이미 더 짧은 경로로 방문된 적이 있으므로(짧은 거리 우선순위 큐이기 때문에) 스킵 (중복 처리 방지용)
            if (curNode.weight != distance[curNode.end]) continue;

            // 유효한 최단 거리 노드이므로, 이 노드를 경유해 인접 노드들의 거리 갱신
            for (Node nextNode : lists[curNode.end]) {
                // curNode가 이웃하는 정점들에 대해 distance 테이블 값보다 curNode를 거쳐가는 것이 더 작은 값일 경우
                if (distance[nextNode.end] > distance[curNode.end] + nextNode.weight) {
                    // distance 테이블 값 갱신
                    distance[nextNode.end] = distance[curNode.end] + nextNode.weight;
                    // 큐에 넣기
                    pq.add(new Node(nextNode.end, distance[nextNode.end]));
                }
            }
        }
    }
}
