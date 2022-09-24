class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int n;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                n = i;
                answer = "김서방은 " + n + "에 있다";
                    break;
            }
        }
        return answer;
    }
}