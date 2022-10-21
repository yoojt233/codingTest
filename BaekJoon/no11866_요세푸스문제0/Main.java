package BaekJoon.no11866_요세푸스문제0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		sb.append("<");
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; ++i)
			q.offer(i);

		while (q.size() > 1) {
			for (int i = 0; i < K - 1; ++i)
				q.offer(q.poll());
			sb.append(q.poll() + ", ");
		}
		sb.append(q.poll() + ">");

		System.out.print(sb);
		br.close();
	}
}
