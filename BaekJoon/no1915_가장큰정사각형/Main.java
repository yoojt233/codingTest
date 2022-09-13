package BaekJoon.no1915_가장큰정사각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean flag = false;
		int row = Integer.parseInt(st.nextToken()); // 가로
		int col = Integer.parseInt(st.nextToken()); // 세로

		int[][] map = new int[row][col];
		for (int i = 0; i < row; ++i) {
			String str = br.readLine();
			for (int j = 0; j < col; ++j) {
				map[i][j] = str.charAt(j) - '0';

				// 1이 있다면 한 칸짜리 정사각형이 존재
				if (map[i][j] == 1)
					flag = true;
			}
		}

		// flag가 false라면 정사각형이 없으므로 0
		int ans = flag ? 1 : 0;

		// (1, 1)부터 좌, 좌상, 상 3칸을 검사
		for (int i = 1; i < row; ++i) {
			for (int j = 1; j < col; ++j) {
				if (map[i][j] == 1 && map[i - 1][j - 1] > 0 && map[i - 1][j] > 0 && map[i][j - 1] > 0) {
					map[i][j] = minimum(map[i - 1][j - 1], map[i - 1][j], map[i][j - 1]) + 1;
					ans = Math.max(ans, map[i][j]); // 최댓값 갱신
				}
			}
		}

		System.out.print(ans * ans);
		br.close();
	}

	// a, b, c 중 최솟값
	private static int minimum(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}