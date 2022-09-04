package BaekJoon.no2470_두용액;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] liquid = new int[N];
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < N; i++)
			liquid[i] = Integer.parseInt(input[i]);

		Arrays.sort(liquid);

		int op = 0; // 시작 인덱스
		int ed = N - 1; // 끝 인덱스
		int left = liquid[op]; // 왼쪽 용액
		int right = liquid[ed]; // 오른쪽 용액
		int sum = Integer.MAX_VALUE; // 합의 절댓값의 최솟값

		while (op < ed) {
			int temp = liquid[op] + liquid[ed];
			if (Math.abs(temp) < sum) { // 새로운 절댓값이 기존의 절댓값보다 작다면 갱신
				sum = Math.abs(temp);
				left = liquid[op]; // 최소 절댓값의 왼쪽 용액
				right = liquid[ed]; // 최소 절댓값의 오른쪽 용액
			}

			if (temp > 0) // 양수일 경우, 값을 줄여야 한다. 오른쪽값 감소
				--ed;
			else // 음수일 경우, 값을 늘려야 한다. 왼쪽값 증가
				++op;
		}

		System.out.printf("%d %d", left, right);
		br.close();
	}
}