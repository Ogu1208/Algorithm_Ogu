import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sArr = s.split("-");
        
        int j1 = Integer.parseInt(sArr[0]);
        int j2 = Integer.parseInt(sArr[1]);
        
        System.out.printf("%06d%d", j1, j2);
        
    }
}
