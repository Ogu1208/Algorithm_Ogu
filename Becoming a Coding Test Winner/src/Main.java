import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

	public static void main(String[] args) {
		int[][] graph1 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}};
		System.out.println(Arrays.toString(solution(graph1, 1, 9)));
		int[][] graph2 = {{1, 3}, {3, 4}, {3, 5}, {5, 2}};
		System.out.println(Arrays.toString(solution(graph2, 1, 5)));
	}

	private static ArrayList<Integer>[] adjList;
	private static boolean[] visited;
	private static ArrayList<Integer> answer;

	private static int[] solution(int[][] graph, int start, int n) {
		adjList = new ArrayList[n + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		visited = new boolean[n + 1];
		answer = new ArrayList<>();

		for (int[] edge : graph) {
			adjList[edge[0]].add(edge[1]);
		}

		bfs(start);

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private static void bfs(int start) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.addLast(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			answer.add(now);

			for(int next : adjList[now]) {
				if (!visited[next]) {
					queue.addLast(next);
					visited[next] = true;
				}
			}
		}
	}

}