package BaekJoon.no6591_이항쇼다운;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int[][] K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		r = n - r > r ? r : n - r;

		while (!isFinished(n, r)) {
			K = new int[n + 1][r + 1];
			sb.append(comb(n, r)).append("\n");

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static int comb(int n, int r) {
		if (r == 0 || r == n)
			return 1;
		else {
			if (K[n][r] == 0)
				K[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
			return K[n][r];
		}
	}

	private static boolean isFinished(int n, int r) {
		if (n == 0 && r == 0)
			return true;
		return false;
	}
}
