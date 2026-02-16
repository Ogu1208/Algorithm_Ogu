import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution36 {

	public static void main(String[] args) {
		int[][] graph = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
		System.out.println(Arrays.toString(solution(graph, 0, 3)));
		int[][] graph2 = {{0, 1, 1}, {1, 2, 5}, {2, 3, 1}};
		System.out.println(Arrays.toString(solution(graph2, 0, 4)));
	}

	// 노드의 정보(노드 번호, 거리)를 쌍으로 저장할 클래스 생성
	private static class Node {
		int dest, cost;

		public Node(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}

	public static int[] solution(int[][] graph, int start, int n) {
		// 인접 리스트를 저장할 ArrayList 배열 초기화
		ArrayList<Node>[] adjList = new ArrayList[n];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		// graph 정보를 인접리스트에 저장
		for (int[] edge : graph) {
			adjList[edge[0]].add(new Node(edge[1], edge[2]));
		}

		// 시작 노드부터 시작 노드를 포함한 모든 노드까지의 최단 거리를 순서대로 저장
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		// 시작 노드의 거리 값은 0으로 초기화
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll(); // 현재 가장 거리가 짧은 노드

			// 현재 노드의 거리 값이 큐에서 가져온 거리 값보다 크면, 해당 노드는 이미 방문한 것이므로 무시
			if (dist[now.dest] < now.cost)
				continue;

			// 현재 노드와 인접한 노드들의 거리 값을 계산해 업데이트
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