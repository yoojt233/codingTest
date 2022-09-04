package BaekJoon.no2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		Queue<Integer> q = new ArrayDeque<Integer>();

		// 카드 번호 큐에 삽입
		for (int i = 1; i <= N; i++)
			q.offer(i);

		// 하나 버리고, 하나 뽑아서 다시 뒤에 삽입
		while (q.size() != 1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.print(q.poll());
	}
}
