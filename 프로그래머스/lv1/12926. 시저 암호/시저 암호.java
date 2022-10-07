class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer += c;
                continue;
            }
            if (c >= 'a' && c <= 'z') {  // 소문자
                if (c + n > 'z') {
                    answer += (char)(c + n - 26);
                } else {
                    answer += (char)(c + n);
                }
            }
            if (c >= 'A' && c <= 'Z') {  // 대문자
                if (c + n > 'Z') {
                    answer += (char)(c + n - 26);
                } else {
                    answer += (char)(c + n);
                }
            }
            int z = c + n;

        }
        return answer;
    }
}