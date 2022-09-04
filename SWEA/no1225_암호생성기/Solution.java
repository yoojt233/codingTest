package SWEA.no1225_암호생성기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
 
    static Queue<Integer> queue;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int tc = 10;
        for (int t = 0; t < tc; t++) {
            // 테스트 케이스 번호
            int num = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringTokenizer s = new StringTokenizer(str);
 
            queue = new ArrayDeque<Integer>();
 
            // 큐에 값 저장
            for (int i = 0; i < 8; i++)
                queue.offer(Integer.parseInt(s.nextToken()));
             
            ecrypt(queue);
             
            sb.append("#").append(num).append(" ");
            for (int i = 0; i < 8; i++)
                sb.append(queue.poll()).append(" ");
            sb.append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
 
    private static void ecrypt(Queue<Integer> q) {
        while (true) {
            for (int i = 1; i < 6; i++) {
                int temp = q.poll();
                if (temp > i)
                    q.offer(temp - i);
                else {
                    q.offer(0);
                    return;
                }
            }
        }
    }
}