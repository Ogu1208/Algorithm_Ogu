import java.util.Scanner;

public class bronze_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iarr[] = new int[26];

        int max = 0;
        char ch = '?';

        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                iarr[s.charAt(i) - 'A']++;
            } else {
                iarr[s.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < iarr.length; i++) {
            if (iarr[i] > max) {
                max = iarr[i];
                ch = (char) (i + 'A');
            } else if (iarr[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);

    }
}
