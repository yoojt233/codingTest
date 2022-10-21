package BaekJoon.no17265_나의인생에는수학과함께;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static String[][] map;
	static int max, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];

		for (int i = 0; i < N; ++i)
			map[i] = br.readLine().split(" ");

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(0, 0, Integer.parseInt(map[0][0]), "");

		System.out.printf("%d %d", max, min);
		br.close();
	}

	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	private static void dfs(int r, int c, int sum, String op) {
		if (r == N - 1 && c == N - 1) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}

		for (int d = 0; d < 2; ++d) {
			int cr = r + dx[d];
			int cc = c + dy[d];

			if (cr < 0 || cr >= N || cc < 0 || cc >= N)
				continue;

			if ("".equals(op))
				dfs(cr, cc, sum, check(map[cr][cc]));
			else
				dfs(cr, cc, calc(op, sum, Integer.parseInt(map[cr][cc])), "");
		}
	}

	private static String check(String n) {
		if ("+".equals(n) || "-".equals(n) || "*".equals(n))
			return n;
		else
			return "";
	}

	private static int calc(String op, int cur, int next) {
		switch (op) {
		case "+":
			return cur + next;
		case "-":
			return cur - next;
		case "*":
			return cur * next;
		default:
			return 0;
		}
	}
}
