import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * bronze_1152
 */
public class bronze_1152 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str;
    str = sc.nextLine();

    StringTokenizer st = new StringTokenizer(str, " ");
    System.out.println(st.countTokens());
  }

}