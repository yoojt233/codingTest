package BaekJoon.no1927_최소힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			int order = Integer.parseInt(br.readLine());

			if (order != 0)
				pq.add(order);
			else if (pq.isEmpty())
				sb.append(0 + "\n");
			else
				sb.append(pq.poll() + "\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
