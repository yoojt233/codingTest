package BaekJoon.no10942_팰린드롬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[][] palindrome;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		palindrome = new int[N][N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++)
				palindrome[i][j] = palin(i, j);
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			sb.append(palindrome[start][end] + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static int palin(int op, int ed) {
		while (op < ed) {
			if (arr[op] == arr[ed]) {
				op++;
				ed--;
			} else
				return 0;
		}
		return 1;
	}
}
