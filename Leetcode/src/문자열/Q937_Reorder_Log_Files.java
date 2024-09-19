package 문자열;

import java.util.ArrayList;
import java.util.List;

public class Q937_Reorder_Log_Files {
    public String[] reorderLogFiles(String[] logs) {

        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for(String log : logs) {
            if(Character.isDigit((log.split(" ")[1]).charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        /**
         * List.sort() 메서드
         *
         * letterList.sort(...) 메서드는 Java 8부터 제공되는 List 인터페이스의 메서드로, 리스트를 제자리에서 정렬
         * 이 메서드는 Comparator를 인자로 받아서 리스트 내 요소들을 비교하고 정렬합니다.
         */

        letterList.sort((s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            int compared = split1[1].compareTo(split2[1]);
            if(compared == 0) {
                return split1[0].compareTo(split2[0]);
            }
            // 같으면 0, 순서가 그대로면 1, 순서가 바뀌면 -1
            return compared;
        });

        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Q937_Reorder_Log_Files q937 = new Q937_Reorder_Log_Files();
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] result = q937.reorderLogFiles(logs);

        for(String log : result) {
            System.out.println(log);
        }
    }
}
