package BaekJoon.no17136_색종이붙이기_unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] use = new int[5];
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[10][10];

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

			}
		}

		System.out.print(ans);
		br.close();
	}

	private static boolean possible(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] == 0 || i > 9 || j > 9)
					return false;
			}
		}
		for (int i : use) {
			if (i > 5)
				return false;
		}

		return true;
	}
}
