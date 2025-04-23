package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11779_최소비용구하기 {
    static int N, M, from, to;
    static ArrayList<Node>[] lists;
    static int[] distance;
    static int[] pre; // 경로
    static int INF = 100_100_100;
    static ArrayList<Integer> channel;
    static int count, cost;

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        lists = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        distance = new int[N + 1];
        pre = new int[N + 1];
        channel = new ArrayList<>();

        Arrays.fill(distance, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        dijkstra(from);

        // 경로 찾아서 배열에  넣기
        int n = to;

        while (true) {
            channel.add(n);
            count++;
            if(n == from) break;

            n = pre[n];
        }
        Collections.reverse(channel);

        System.out.println(distance[to]); // 최소 비용
        System.out.println(count); // 경로에 포함되어 있는 도시의 개수
        for (int city : channel) {
            System.out.print(city + " ");
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;
        pre[start] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            // distance 의 값과 비교해서 같지 않으면 패스
            if (distance[currentNode.end] != currentNode.weight) continue;

            for (Node nextNode : lists[currentNode.end]) {
                if (currentNode.weight + nextNode.weight < distance[nextNode.end]) {
                    distance[nextNode.end] = currentNode.weight + nextNode.weight;
                    pq.add(new Node(nextNode.end, distance[nextNode.end]));
                    pre[nextNode.end] = currentNode.end;
                }
            }
        }
    }
}
