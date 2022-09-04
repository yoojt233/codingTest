package BaekJoon.no2469_사다리타기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int K, n, where;
	static char[][] ladder;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine()); // 참가 인원 수
		n = Integer.parseInt(br.readLine()); // 가로 줄 수
		where = 0; // ? 위치

		char[] start = new char[K];
		for (int i = 0; i < K; i++)
			start[i] = (char) ('A' + i);
		char[] first = start.clone();
		char[] end = br.readLine().toCharArray();
		char[] target = end.clone();

		ladder = new char[n][K - 1];
		for (int i = 0; i < n; i++)
			ladder[i] = br.readLine().toCharArray();

		down(0, start);
		up(n - 1, end);

		char[] ans = new char[K - 1];
		Arrays.fill(ans, '*');
		for (int i = 0; i < K - 1; i++) {
			if (start[i] != end[i])
				ans[i++] = '-';
		}
		ladder[where] = ans;
		down(0, first);

		for (int i = 0; i < K - 1; i++) {
			if (first[i] != target[i]) {
				Arrays.fill(ans, 'x');
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : ans)
			sb.append(c);
		System.out.print(sb.toString());
	}

	private static void down(int idx, char[] arr) {
		while (ladder[idx][0] != '?') {
			for (int i = 0; i < K - 1; i++) {
				if (ladder[idx][i] == '-')
					swap(arr, i);
			}
			idx++;
			if (idx == n)
				break;
		}
		where = idx;
	}

	private static void up(int idx, char[] arr) {
		while (ladder[idx][0] != '?') {
			for (int i = 0; i < K - 1; i++) {
				if (ladder[idx][i] == '-')
					swap(arr, i);
			}
			idx--;
		}
	}

	private static void swap(char[] arr, int idx) {
		char temp = arr[idx];
		arr[idx] = arr[idx + 1];
		arr[idx + 1] = temp;
	}
}
