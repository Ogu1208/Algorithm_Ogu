class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String str = s.toLowerCase();
        int pCount = 0;
        int sCount = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'p') {
                pCount++;
            } else if (str.charAt(i) == 'y') {
                sCount++;
            }
        }
        
        if (pCount!=sCount) {
            return false;
        } else {
            return true;
        }
    }
}