import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        String sArr[] = s.split("\\.");
        
        System.out.println(sArr[0]);
        System.out.println(sArr[1]);
    }
}
