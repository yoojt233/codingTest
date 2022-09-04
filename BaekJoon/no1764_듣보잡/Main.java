package BaekJoon.no1764_듣보잡;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> hear = new HashSet<>(N);
		for (int i = 0; i < N; i++)
			hear.add(br.readLine());

		PriorityQueue<String> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (hear.contains(str))
				pq.add(str);
		}

		sb.append(pq.size() + "\n");
		for (String s : pq)
			sb.append(s + "\n");

		System.out.print(sb.toString());
		br.close();
	}
}
