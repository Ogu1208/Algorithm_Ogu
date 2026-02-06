import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution35 {

	public static void main(String[] args) {
		int[][] graph1 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}};
		System.out.println(Arrays.toString(solution(graph1, 1, 9)));
		int[][] graph2 = {{1, 3}, {3, 4}, {3, 5}, {5, 2}};
		System.out.println(Arrays.toString(solution(graph2, 1, 5)));
	}

	// 인접 리스트
	private static ArrayList<Integer>[] adjList;
	private static ArrayList<Integer> answer;
	private static boolean[] visited;

	// 이 부분을 변경해서 실행해보세요.
	private static int[] solution(int[][] graph, int start, int n) {
		adjList = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 그래프를 인접리스트로 변환
		for (int i = 0; i < graph.length; i++) {
			adjList[graph[i][0]].add(graph[i][1]);
		}

		visited = new boolean[n + 1];
		answer = new ArrayList<>();

		bfs(start);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	// BFS 탐색
	private static void bfs(int start) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		visited[start] = true;
		queue.addLast(start);

		while (!queue.isEmpty()) {
			Integer now = queue.pollFirst();
			answer.add(now);
			for (int next : adjList[now]) {
				if (!visited[next]) {
					queue.addLast(next);
					visited[next] = true;
				}
			}
		}
	}

}