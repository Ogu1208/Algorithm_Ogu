class Solution {
    public String solution(String s) {
        String answer = "";
        int gap = 'a' - 'A';
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'z') {
                count++;
                if (count % 2 == 1 && (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                    answer += (char) (s.charAt(i) - gap);
                } else if (count % 2 == 0 && (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                    answer += (char) (s.charAt(i) + gap);
                } else {  // 바꾸지 않아도 될 경우
                    answer += s.charAt(i);
                }

            } else {   // 공백인 경우
                count = 0;
                answer += s.charAt(i);
            }
            System.out.println(s.charAt(i) + ", couont: " + count);
        }
        return answer;
    }
}