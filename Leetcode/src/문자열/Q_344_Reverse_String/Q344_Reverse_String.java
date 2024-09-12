package 문자열.Q_344_Reverse_String;

public class Q344_Reverse_String {
    public static void revserseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
        revserseString(s);
        System.out.println(s);
    }
}
