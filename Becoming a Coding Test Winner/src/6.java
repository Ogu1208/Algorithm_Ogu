import java.util.ArrayList;
import java.util.List;

class Solution6 {

	static class Stage {
		int stage;
		double failRate;

		public Stage(int stage, double failRate) {
			this.stage = stage;
			this.failRate = failRate;
		}
	}

	public int[] solution(int N, int[] stages) {

		int[] answer = new int[N];

		int[] stopCount = new int[N + 2];
		for (int i : stages) {
			stopCount[i]++;
		}

		List<Stage> list = new ArrayList<>();
		int players = stages.length; // 현재 스테이지에 도달한 플레이어 수

		for (int i = 1; i <= N; i++) {
			double failRate;

			if (players == 0) {
				failRate = 0;
			} else {
				failRate = (double)stopCount[i] / players;
			}

			list.add(new Stage(i, failRate));
			players -= stopCount[i];
		}

		list.sort((a, b) -> {
			if (Double.compare(b.failRate, a.failRate) != 0) {
				return Double.compare(b.failRate, a.failRate);
			}
			return Double.compare(a.stage, b.stage);
		});

		for (int i = 0; i < N; i++) {
			answer[i] = list.get(i).stage;
		}

		return answer;
	}
}