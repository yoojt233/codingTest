package BaekJoon.no26215_눈치우기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; ++i)
			pq.add(Integer.parseInt(st.nextToken()));

		int ans = 0;
		int[] snow = new int[2];
		while (!pq.isEmpty() && ans <= 1440) {
			if (pq.size() > 1) {
				++ans;

				for (int i = 0; i < 2; ++i)
					snow[i] = pq.poll() - 1;

				for (int i = 0; i < 2; ++i) {
					if (snow[i] > 0)
						pq.add(snow[i]);
				}
			} else
				ans += pq.poll();
		}

		System.out.print(ans > 1440 ? -1 : ans);
		br.close();
	}
}
