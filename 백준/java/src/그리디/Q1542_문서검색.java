package 그리디;

import java.io.*;
import java.util.StringTokenizer;

public class Q1542_문서검색 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String doc = br.readLine();
        String word = br.readLine();

        int count = 0;
        int index = 0;

        while (true) {
            index = doc.indexOf(word, index);
            if (index < 0) break;
            count ++;
            index += word.length();
        }

        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
    }
}
