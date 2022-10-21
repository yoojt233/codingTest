package BaekJoon.no6987_월드컵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] score;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ans = "";
		for (int t = 0; t < 4; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			score = new int[6][3];

			int total = 0;
			// 0: 승 1: 무 2: 패
			for (int i = 0; i < 6; ++i) {
				for (int j = 0; j < 3; ++j) {
					score[i][j] = Integer.parseInt(st.nextToken());
					total += score[i][j];
				}
			}

			flag = false;
			if (total == 30)
				dfs(0);

			ans += flag ? "1 " : "0 ";
		}

		System.out.print(ans);
		br.close();
	}

	static int[][] duel = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 }, { 0, 5 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 4 }, { 2, 5 }, { 3, 4 }, { 3, 5 }, { 4, 5 } };

	private static void dfs(int cnt) {
		if (flag)
			return;

		if (cnt == 15) {
			flag = true;
			return;
		}

		int a = duel[cnt][0];
		int b = duel[cnt][1];
		win(cnt, a, b);
		draw(cnt, a, b);
		lose(cnt, a, b);
	}

	private static void win(int cnt, int a, int b) {
		--score[a][0];
		--score[b][2];
		if (score[a][0] >= 0 && score[b][2] >= 0)
			dfs(cnt + 1);
		++score[a][0];
		++score[b][2];
	}

	private static void draw(int cnt, int a, int b) {
		--score[a][1];
		--score[b][1];
		if (score[a][1] >= 0 && score[b][1] >= 0)
			dfs(cnt + 1);
		++score[a][1];
		++score[b][1];
	}

	private static void lose(int cnt, int a, int b) {
		--score[a][2];
		--score[b][0];
		if (score[a][2] >= 0 && score[b][0] >= 0)
			dfs(cnt + 1);
		++score[a][2];
		++score[b][0];
	}
}
