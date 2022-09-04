package BaekJoon.no1915_가장큰정사각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean flag = false;
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		int[][] map = new int[row][col];
		for (int i = 0; i < row; ++i) {
			String str = br.readLine();
			for (int j = 0; j < col; ++j) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 1)
					flag = true;
			}
		}

		int ans = flag ? 1 : 0;
		for (int i = 1; i < row; ++i) {
			for (int j = 1; j < col; ++j) {
				if (map[i][j] == 1 && map[i - 1][j - 1] > 0 && map[i - 1][j] > 0 && map[i][j - 1] > 0) {
					map[i][j] = minimum(map[i - 1][j - 1], map[i - 1][j], map[i][j - 1]) + 1;
					ans = Math.max(ans, map[i][j]);
				}
			}
		}

		System.out.print(ans * ans);
		br.close();
	}

	private static int minimum(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}