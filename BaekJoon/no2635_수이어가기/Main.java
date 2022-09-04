package BaekJoon.no2635_수이어가기;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int MAX;
	static Integer[] ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		MAX = Integer.MIN_VALUE;
		int standard = sc.nextInt();

		List<Integer> numbers = new LinkedList<>();
		ans = new Integer[2];

		int idx = 0; // 비교할 1번째 idx 값
		while (idx++ <= standard) {
			numbers.add(standard); // 0번째 idx 값 고정
			numbers.add(idx);
			int temp = numbers.get(numbers.size() - 2) - numbers.get(numbers.size() - 1);
			if (temp >= 0)
				next(2, numbers, temp);
		}
		sb.append(MAX).append("\n");
		for (Integer i : ans)
			sb.append(i).append(" ");
		System.out.print(sb.toString());
		sc.close();
	}

	private static void next(int cnt, List<Integer> numbers, int temp) {
		if (temp < 0) {
			MAX = Math.max(MAX, cnt);
			if (MAX == cnt) {
				ans = numbers.toArray(new Integer[numbers.size()]);
			}
			numbers.clear();
			return;
		}
		numbers.add(temp);
		next(cnt + 1, numbers, numbers.get(numbers.size() - 2) - numbers.get(numbers.size() - 1));
	}
}
