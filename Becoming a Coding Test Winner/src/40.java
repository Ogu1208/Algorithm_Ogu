import java.util.*;

class Solution40 {

	private static class Node {
		int dest, cost;

		public Node (int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}

	public int solution(int N, int[][] road, int K) {
		int answer = 0;

		ArrayList<Node>[] adjList = new ArrayList[N + 1];
		for (int i = 0; i <= N; i ++) {
			adjList[i] = new ArrayList<>();
		}

		for(int[] edge : road) {
			adjList[edge[0]].add(new Node(edge[1], edge[2]));
			adjList[edge[1]].add(new Node(edge[0], edge[2]));
		}

		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		pq.add(new Node(1, 0));
		dist[1] = 0;

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

		for (int i = 1; i <= N; i++) {
			if (dist[i] <= K)
				answer++;
		}


		return answer;
	}
}