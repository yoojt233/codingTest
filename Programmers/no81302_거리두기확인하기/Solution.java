package Programmers.no81302_거리두기확인하기;

import java.util.ArrayList;

class Solution {
	static boolean[][] visited;

	public static int[] solution(String[][] places) {
		int[] ans = new int[5];

		for (int t = 0; t < 5; ++t) {
			String[] room = places[t];

			ArrayList<int[]> people = new ArrayList<>();

			char[][] map = new char[5][5];
			for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 5; ++j) {
					map[i][j] = room[i].charAt(j);
					if (map[i][j] == 'P')
						people.add(new int[] { i, j });
				}
			}

		}

		return ans;
	}
}

class pos {
	int x, y;

	public pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}