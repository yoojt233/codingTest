package BaekJoon.no3187_양치기꿍;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map; // 맵
	static boolean[][] checked; // 방문 여부
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int row, col, area_sheep, area_wolf; // 가로, 세로, 구역 내 양 수, 구역 내 늑대 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new char[row][col];
		checked = new boolean[row][col];

		for (int i = 0; i < row; i++)
			map[i] = br.readLine().toCharArray();

		int sheep = 0; // 살아남은 양
		int wolf = 0; // 살아남은 늑대

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (checked[i][j])
					continue;
				else {
					if (map[i][j] == 'v' || map[i][j] == 'k') {
						area_sheep = 0;
						area_wolf = 0;
						dfs(i, j);
						if (area_sheep > area_wolf) // 양 win
							sheep += area_sheep;
						else
							wolf += area_wolf;
					}
				}
			}
		}
		System.out.printf("%d %d", sheep, wolf);
		br.close();
	}

	private static void dfs(int x, int y) {
		checked[x][y] = true;

		if (map[x][y] == 'k')
			area_sheep++; // 이 구역 양 몇 마리?
		else if (map[x][y] == 'v')
			area_wolf++; // 이 구역 늑대 몇 마리?

		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx >= 0 && cx < row && cy >= 0 && cy < col && !checked[cx][cy] && map[cx][cy] != '#') {
				dfs(cx, cy);
			}
		}
	}
}

// .(빈공간) #(울타리) v(늑대) k(양)