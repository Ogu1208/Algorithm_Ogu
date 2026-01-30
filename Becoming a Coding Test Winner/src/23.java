import static java.util.Map.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 내 코드 : “한 사람이 누구를 신고했는가”
 * 	1.	신고자 기준으로 중복 제거
 * 	2.	신고당한 사람 카운트
 * 	3.	k 이상인 사람 Set 생성
 * 	4.	다시 신고자 기준으로 메일 수 계산
 */
class Solution23 {

	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		HashMap<String, Integer> reportedCount = new HashMap<>();
		HashMap<String, HashSet<String>> namesIReported = new HashMap<>();

		for (int i = 0; i < report.length; i++) {
			StringTokenizer st = new StringTokenizer(report[i]);
			String reporter = st.nextToken();
			String reported = st.nextToken();

			if (
				namesIReported
					.computeIfAbsent(reporter, key -> new HashSet<>()) // 없으면 new HashSet<>() 만들어서 넣고 반환, 있으면 기존 Set 반환
					.add(reported) 											 // 이미 있으면 false 반환
			) {
				reportedCount.put(reported, reportedCount.getOrDefault(reported, 0) + 1);
			}
		}

		Set<String> reportedPeople = reportedCount.entrySet()
			.stream()
			.filter(entry -> entry.getValue() >= k)
			.map(Entry::getKey)
			.collect(Collectors.toSet());

		for (int i = 0; i < id_list.length; i++) {
			if (!namesIReported.containsKey(id_list[i])) {
				continue;
			}

			HashSet<String> nameSet = namesIReported.get(id_list[i]);
			answer[i] = (int)nameSet.stream().filter(name -> reportedPeople.contains(name)).count();
		}

		return answer;
	}
}