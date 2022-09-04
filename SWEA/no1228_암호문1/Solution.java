package SWEA.no1228_암호문1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    static LinkedList<String> list;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st1, st2, st3;
        
        for (int t = 1; t <= 10; t++) {
            sb.append("#").append(t).append(" "); // #테케 번호
 
            list = new LinkedList<String>();
            int N = Integer.parseInt(br.readLine()); 
 
            String str = br.readLine();
            st1 = new StringTokenizer(str);
            
            for (int i = 0; i < N; i++)
                list.add(st1.nextToken());
 
            int cnt = Integer.parseInt(br.readLine());
            str = br.readLine();
            st2 = new StringTokenizer(str, "I");
            
            while (st2.hasMoreTokens()) {
                String data = st2.nextToken();
                st3 = new StringTokenizer(data);
                
                int mark = Integer.parseInt(st3.nextToken());
                int count = Integer.parseInt(st3.nextToken());
                
                ArrayList<String> sub = new ArrayList<String>(count);
                
                for (int i = 0; i < count; i++)
                    sub.add(st3.nextToken());
                list.addAll(mark, sub);
            }
            for (int i = 0; i < 10; i++)
                sb.append(list.get(i)).append(" ");
            sb.append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}