package BaekJoon.no9184_신나는함수실행;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][][] f = new int[21][21][21];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		// 0,0,0 ~ 20,20,20 까지 memoization
		for (int i = 0; i <= 20; i++)
			for (int j = 0; j <= 20; j++)
				for (int k = 0; k <= 20; k++)
					f[i][j][k] = w(i, j, k);

		while (!isFinished(a, b, c)) { // isFinished가 true가 될 때까지 돈다. ( -1, -1, -1 )
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c))
					.append("\n");

			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;
		else if (a > 20 || b > 20 || c > 20)
			return f[20][20][20];
		else if (a < b && b < c)
			return f[a][b][c - 1] + f[a][b - 1][c - 1] - f[a][b - 1][c];
		else
			return f[a - 1][b][c] + f[a - 1][b - 1][c] + f[a - 1][b][c - 1] - f[a - 1][b - 1][c - 1];
	}

	// -1, -1, -1 검사
	private static boolean isFinished(int a, int b, int c) {
		if (a == -1 && b == -1 && c == -1)
			return true;
		return false;
	}
}
