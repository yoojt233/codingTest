package BaekJoon.no13975_파일합치기3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				pq.add(Long.parseLong(st.nextToken()));

			long total = 0;
			while (pq.size() > 1) {
				long x = pq.poll() + pq.poll();
				total += x;
				pq.add(x);
			}

			sb.append(total + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}
