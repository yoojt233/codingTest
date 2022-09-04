package BaekJoon.no2548_대표자연수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int num[];
	static int min, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 자연수 갯수

		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(num);

		min = Integer.MAX_VALUE;
		ans = Integer.MAX_VALUE;
		for (int i = 1; i <= num[N - 1]; i++)
			sum(i, num);

		System.out.print(ans);
		br.close();
	}

	private static void sum(int x, int[] num) {
		int total = 0;
		for (int i = 0, n = num.length; i < n; i++) {
			total += Math.abs(x - num[i]);
			if (total >= min)
				return;
		}
		min = total;
		ans = x;
	}
}
