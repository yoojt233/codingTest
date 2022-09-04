package BaekJoon.no2559_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 온도 몇 개?
		int K = Integer.parseInt(st.nextToken()); // 몇 개 더 해?
		int[] temp = new int[N];
		int MAX = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		// 온도 배열
		for (int i = 0; i < N; i++)
			temp[i] = Integer.parseInt(st.nextToken());

		for (int i = 0, n = N - K + 1; i < n; i++)
			MAX = Math.max(sum(temp, i, i + K), MAX);

		System.out.print(MAX);
		br.close();
	}

	private static int sum(int[] temp, int start, int end) {
		int total = 0;
		for (int i = start; i < end; i++)
			total += temp[i];
		return total;
	}
}
