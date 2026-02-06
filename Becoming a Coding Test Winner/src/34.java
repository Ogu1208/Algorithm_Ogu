import java.util.ArrayList;
import java.util.Arrays;

class Solution34 {

	public static void main(String[] args) {
		int[][] graph1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		System.out.println(Arrays.toString(solution(graph1, 1, 5)));
		int[][] graph2 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}};
		System.out.println(Arrays.toString(solution(graph2, 1, 6)));
	}

	// 인접 리스트 저장할 ArrayList 배열
	private static ArrayList<Integer>[] adjList;
	// 방문 여부를 저장할 boolean 배열
	private static boolean[] visited;
	private static ArrayList<Integer> answer;

	private static int[] solution(int[][] graph, int start, int n) {
		// 인접 리스트 초기화
		adjList = new ArrayList[n + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 그래프를 인접리스트로 변환
		for (int i = 0; i < graph.length; i++) {
			adjList[graph[i][0]].add(graph[i][1]);
		}

		visited = new boolean[n + 1];
		answer = new ArrayList<>();

		dfs(start);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	// DFS 탐색 (재귀) - 함수에 들어온 순간 (pop된 순간) 방문 처리
	private static void dfs(int now) {
		visited[now] = true;  // 현재 노드 방문 처리
		answer.add(now);    // 현재 노드 결과 리스트에 추가

		for (int next : adjList[now]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}