package BaekJoon.no1461_도서관;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int M; // 한 번에 몇 개

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int max = 0; // 최댓값은 한 번만 계산

		List<Integer> left = new ArrayList<>(); // 음수 리스트
		List<Integer> right = new ArrayList<>(); // 양수 리스트

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp < 0)
				left.add(Math.abs(temp));
			else
				right.add(temp);

			// 최댓값 갱신
			if (Math.abs(temp) > max)
				max = Math.abs(temp);
		}

		Collections.sort(left);
		Collections.sort(right);

		System.out.print(step(left) + step(right) - max);
		br.close();
	}

	private static int step(List<Integer> list) {
		int temp = 0;

		Stack<Integer> s = new Stack<Integer>();
		for (int i : list)
			s.add(i);

		int cnt = 0;
		while (!s.isEmpty()) {

			// M권 마다 걸음 수 계산
			if (cnt % M == 0)
				temp += s.pop() * 2;
			else
				s.pop();
			cnt++;
		}

		return temp;
	}
}
