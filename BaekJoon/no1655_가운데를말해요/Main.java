package BaekJoon.no1655_가운데를말해요;

import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // 중간값 이하의 우선순위 큐
		PriorityQueue<Integer> big = new PriorityQueue<>(); // 중간값보다 큰 우선순위 큐

		// 처음 수는 small에 삽입
		small.add(Integer.parseInt(br.readLine()));

		// 중간값
		int mid = small.peek();
		sb.append(mid);

		for (int i = 0; i < N - 1; ++i) {
			int cur = Integer.parseInt(br.readLine());

			// 입력받은 값과 중간값 비교
			if (cur > mid)
				big.add(cur);
			else
				small.add(cur);

			check(big, small);
			mid = small.peek(); // 중간값 갱신
			sb.append("\n" + mid);
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void check(PriorityQueue<Integer> big, PriorityQueue<Integer> small) {
		int s = small.size();
		int b = big.size();

		if (b > s)
			small.add(big.poll()); // big -> small
		else if (s - b == 2)
			big.add(small.poll()); // small -> big
	}
}
