package BaekJoon.no19638_센티와마법의뿅망치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int centi = Integer.parseInt(st.nextToken());
		int chance = Integer.parseInt(st.nextToken());

		boolean flag = false;
		PriorityQueue<Integer> giant = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++)
			giant.add(Integer.parseInt(br.readLine()));

		int cur = giant.peek();
		if (cur < centi) {
			flag = true;
			chance = 0;
		} else {
			for (int i = 1; i <= chance; i++) {
				cur = check(giant.poll());
				if (cur < centi && rest(giant, centi)) {
					chance = i;
					flag = true;
					break;
				} else
					giant.add(cur);
			}
		}

		if (flag)
			sb.append("YES\n" + chance);
		else
			sb.append("NO\n" + giant.peek());

		System.out.print(sb.toString());
		br.close();
	}

	private static boolean rest(PriorityQueue<Integer> giant, int centi) {
		if (giant.isEmpty())
			return true;
		else {
			if (giant.peek() < centi)
				return true;
			else
				return false;
		}
	}

	private static int check(int temp) {
		if (temp > 1)
			return temp / 2;
		else
			return 1;
	}
}
