package BaekJoon.no1715_카드정렬하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int ans = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++)
			pq.add(Integer.parseInt(br.readLine()));

		while (pq.size() > 1) {
			int temp = pq.poll() + pq.poll();
			pq.add(temp);
			ans += temp;
		}

		System.out.print(ans);
		br.close();
	}
}
