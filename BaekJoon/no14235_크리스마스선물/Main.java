package BaekJoon.no14235_크리스마스선물;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			if (temp == 0) {
				sb.append(pq.isEmpty() ? -1 : pq.poll());
				sb.append("\n");
			} else {
				for (int i = 0; i < temp; ++i)
					pq.offer(Integer.parseInt(st.nextToken()));
			}
		}

		System.out.print(sb);
		br.close();
	}
}
