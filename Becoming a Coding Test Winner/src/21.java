import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution21 {

	public String[] solution(String[] record) {
		ArrayList<String> answer = new ArrayList<>();
		HashMap<String, String> uidNameMap = new HashMap<>();

		// 1. uid -> nickname 매핑
		for (String offset : record) {
			StringTokenizer st = new StringTokenizer(offset);

			String command = st.nextToken();
			String uid = st.nextToken();

			if (command.equals("Enter") || command.equals("Change")) {
				String nickname = st.nextToken();
				uidNameMap.put(uid, nickname);
			}
		}

		// 2 . 메시지 생성
		for (String offset : record) {
			StringTokenizer st = new StringTokenizer(offset);

			String command = st.nextToken();
			String uid = st.nextToken();

			if (command.equals("Enter")) {
				answer.add(uidNameMap.get(uid) + "님이 들어왔습니다.");
			} else if (command.equals("Leave")) {
				answer.add(uidNameMap.get(uid) + "님이 나갔습니다.");
			}
		}

		return answer.toArray(new String[0]);
	}
}