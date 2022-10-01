class Solution {
    public boolean solution(String s) {
       if (!(s.length() == 4 || s.length() == 6)) {
            return false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'A' && c <= 'z') {
                    return false;
                }
            }
            return true;
        }
    }
}