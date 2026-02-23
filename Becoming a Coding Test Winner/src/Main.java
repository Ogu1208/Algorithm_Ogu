import java.util.ArrayDeque;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

	public static void main(String[] args) {
	}

	// 상, 하, 좌, 우
	private static final int[] dirR = {0, 0, 1, -1};
	private static final int[] dirC = {1, -1, 0, 0};

	public static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public int solution(int[][] maps) {
		int N = maps.length;
		int M = maps[0].length;

		// 최단 거리 저장
		int[][] dist = new int[N][M];

		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.addLast(new Node(0, 0));
		dist[0][0] = 1;

		while (!queue.isEmpty()) {
			Node now = queue.pollFirst();

			for (int i = 0; i < 4; i++) {
				int nr = now.r + dirR[i];
				int nc = now.c + dirC[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}

				if (maps[nr][nc] == 0) {
					continue;
				}

				if (dist[nr][nc] == 0) {
					queue.addLast(new Node(nr, nc));
					dist[nr][nc] = dist[now.r][now.c] + 1; // 방문 처리
				}
			}
		}

		return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
	}

}