import java.util.Scanner;

public class bronze_1157_re {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int step = (int) ('a' - 'A');
    int[] iarr = new int[step];

    String s = sc.nextLine();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
        iarr[(int) (s.charAt(i) - 'A')]++;
      } else {
        iarr[(int) (s.charAt(i) - 'a')]++;
      }
    }

    int max = 0;
    char c = '?';

    for (int i = 0; i < iarr.length; i++) {
      if (iarr[i] > max) {
        max = iarr[i];
        c = (char) (i + 'A');
      } else if (iarr[i] == max) {
        c = '?';
      }
    }

    System.out.println(c);

  }
}
