package BaekJoon.no2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static char[][] map;
	static boolean[][] check;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		List<Integer> apt = new ArrayList<Integer>();

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		check = new boolean[N][N];

		// 지도 생성
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '0')
					check[i][j] = true;
				else if (!check[i][j]) {
					apt.add(bfs(i, j));
					cnt++;
				}
			}
		}
		Collections.sort(apt);
		sb.append(cnt).append("\n");
		for (int i : apt)
			sb.append(i).append("\n");
		System.out.print(sb.toString());
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int bfs(int x, int y) {
		int cnt = 0;

		Queue<pos> q = new LinkedList<pos>();
		q.offer(new pos(x, y));

		while (!q.isEmpty()) {
			pos temp = q.poll();
			cnt++;
			x = temp.x;
			y = temp.y;
			check[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if (cx >= 0 && cx < N && cy >= 0 && cy < N && map[cx][cy] == '1' && !check[cx][cy]) {
					q.offer(new pos(cx, cy));
					check[cx][cy] = true;
				}
			}
		}
		return cnt;
	}
}

class pos {
	int x, y;

	public pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
