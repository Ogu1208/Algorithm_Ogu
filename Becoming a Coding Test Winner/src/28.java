import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

class Solution28 {

	public static class Info {
		int node, sheep, wolf; // 현재 위치, 양의 수, 늑대의 수
		HashSet<Integer> visited;

		public Info(int node, int sheep, int wolf, HashSet<Integer> visited) {
			this.node = node;
			this.sheep = sheep;
			this.wolf = wolf;
			this.visited = visited;
		}
	}

	private static ArrayList<Integer>[] tree; // 트리 정보를 저장할 인접 리스트

	private static void buildTree(int[] info, int[][] edges) {
		tree = new ArrayList[info.length];

		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int[] edge : edges) {
			tree[edge[0]].add(edge[1]);
		}
	}

	public int solution(int[] info, int[][] edges) {
		buildTree(info, edges);
		int answer = 0;

		// BFS를 위한 큐 생성 및 초기 상태 설정
		ArrayDeque<Info> queue = new ArrayDeque<>();
		queue.add(new Info(0, 1, 0, new HashSet<>()));

		// BFS 시작
		while (!queue.isEmpty()) {
			// 큐에서 현재 상태 꺼냄
			Info now = queue.poll();
			// 최대 양의 수 업데이트
			answer = Math.max(answer, now.sheep);
			// 방문한 노드 집합에 현재 노드의 이웃 노드(자식들) 추가
			now.visited.addAll(tree[now.node]);

			// 인접한 노드들 탐색
			for (int next : now.visited) {
				// 기존 해시셋 데이터를 복사, 현재 방문한 정점을 해시셋에서 제거
				HashSet<Integer> set = new HashSet<>(now.visited); // 당장 선택할 수 있는 후보 노드들
				set.remove(next);

				if (info[next] == 1) { // 늑대일 경우
					if (now.sheep > now.wolf + 1) { // 늑대가 한마리 늘어도 잡아먹히지 않는 경우
						queue.addLast(new Info(next, now.sheep, now.wolf + 1, set));
					}
				} else { // 양일 경우
					queue.addLast(new Info(next, now.sheep + 1, now.wolf, set));
				}
			}
		}

		return answer;
	}
}