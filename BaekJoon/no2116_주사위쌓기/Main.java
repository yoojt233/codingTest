package BaekJoon.no2116_주사위쌓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, MAX;
	static dice[] dices;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		MAX = Integer.MIN_VALUE;
		dices = new dice[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dices[i] = new dice(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),
					st.nextToken());
		}

		for (int i = 1; i <= 6; i++)
			dfs(0, i, 0); // 횟수, 윗면의 숫자, 합

		System.out.print(MAX);
		br.close();
	}

	private static void dfs(int cnt, int top, int sum) {
		if (cnt == N) {
			MAX = Math.max(MAX, sum);
			return;
		}

		dfs(cnt + 1, dices[cnt + 1].next(top), sum + dices[cnt + 1].getMax(top));
	}

	static class dice {
		int a, b, c, d, e, f;

		// 다음 주사위의 면
		int next(int x) {
			if (x == this.a)
				return this.f;
			else if (x == this.b)
				return this.d;
			else if (x == this.c)
				return this.e;
			else if (x == this.d)
				return this.b;
			else if (x == this.e)
				return this.c;
			else
				return this.a;
		}

		// 옆면들 중 최댓값
		int getMax(int x) {
			int max = 0;
			if (x == a || x == f)
				max = Math.max(Math.max(b, d), Math.max(c, e));
			else if (x == b || x == d)
				max = Math.max(Math.max(a, f), Math.max(c, e));
			else
				max = Math.max(Math.max(a, f), Math.max(b, d));
			return max;
		}

		public dice(String a, String b, String c, String d, String e, String f) {
			super();
			this.a = Integer.parseInt(a);
			this.b = Integer.parseInt(b);
			this.c = Integer.parseInt(c);
			this.d = Integer.parseInt(d);
			this.e = Integer.parseInt(e);
			this.f = Integer.parseInt(f);
		}
	}
}
