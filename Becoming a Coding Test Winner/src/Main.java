import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

	public static void main(String[] args) {
		int[][] graph = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
		System.out.println(Arrays.toString(solution(graph, 0, 3)));
		int[][] graph2 = {{0, 1, 1}, {1, 2, 5}, {2, 3, 1}};
		System.out.println(Arrays.toString(solution(graph2, 0, 4)));
	}

	private static class Node {
		int dest, cost;

		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}

	// 이 부분을 변경해서 실행해보세요.
	public static int[] solution(int[][] graph, int start, int n) {
		ArrayList<Node>[] adjList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int edge[] : graph) {
			adjList[edge[0]].add(new Node(edge[1], edge[2]));
		}

		int[] dist = new int[n]; // 거리 저장할 배열
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] visited = new boolean[n]; // 방문 여부를 저장할 배열

		dist[start] = 0; // 시작 노드의 거리 값은 0으로 초기화

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (visited[now.dest])
				continue;

			visited[now.dest] = true;

			for (Node next : adjList[now.dest]) {
				if (dist[next.dest] > now.cost + next.cost) {
					dist[next.dest] = now.cost + next.cost;
					pq.add(new Node(next.dest, dist[next.dest]));
				}
			}
		}

		return dist;
	}

}