import static java.util.Map.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

class Solution22 {

	public int[] solution(String[] genres, int[] plays) {
		ArrayList<Integer> answer = new ArrayList<>();

		HashMap<String, Integer> genreCount = new HashMap<>();
		HashMap<String, ArrayList<int[]>> genreList = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			genreCount.put(
				genres[i],
				genreCount.getOrDefault(genres[i], 0) + plays[i]
			);

			// genres[i] 는 map에서 찾을 key,
			// 없을 경우에만 그 key 값이 k로 람다에 전달돼서
			// new ArrayList<>를 만들고, 그 결과로 나온 리스트에 .add
			genreList
				.computeIfAbsent(genres[i], k -> new ArrayList<>())
				.add(new int[] {i, plays[i]});
		}

		Stream<Entry<String, Integer>> sortedGenre = genreCount.entrySet()
			.stream()
			.sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));

		sortedGenre.forEach(entry -> {
			Stream<int[]> sortedSongs = genreList.get(entry.getKey()).stream()
				.sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
				.limit(2);

			sortedSongs.forEach(song -> answer.add(song[0]));
		});

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}