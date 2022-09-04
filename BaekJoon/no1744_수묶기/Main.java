package BaekJoon.no1744_수묶기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static boolean zero;
	static List<Integer> positive, negative;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		positive = new ArrayList<>(); // 양수 리스트
		negative = new ArrayList<>(); // 음수 리스트

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x > 0)
				positive.add(x);
			else if (x < 0)
				negative.add(x);
			else
				zero = true;
		}

		Collections.sort(positive);
		Collections.sort(negative);

		int pn = positive.size(), nn = negative.size();

		int ans = 0;
		if (pn > 0) // 양수는 스택(뒤에서부터 곱셈)
			ans += goStack(0, pn);

		if (nn > 0) // 음수는 큐(앞에서부터 곱셈)
			ans += goQueue(0, nn);

		System.out.print(ans);
		br.close();
	}

	private static int goQueue(int start, int end) {
		int sum = 0;
		Queue<Integer> q = new LinkedList<>();
		for (int i : negative)
			q.offer(i);

		while (q.size() > 1)
			sum += (q.poll() * q.poll());

		// 0이 있다면 곱셈이 이득이지만, 없다면 더할 수 밖에 없다.
		if (!q.isEmpty() && !zero)
			sum += q.poll();

		return sum;
	}

	private static int goStack(int start, int end) {
		int sum = 0;
		Stack<Integer> s = new Stack<>();
		for (int i : positive)
			s.add(i);

		while (s.size() > 1) {
			int a = s.pop(), b = s.pop();

			// 1은 곱셈보다 덧셈이 유리
			if (a == 1 || b == 1)
				sum += (a + b);
			else
				sum += a * b;
		}

		if (!s.isEmpty())
			sum += s.pop();

		return sum;
	}
}
