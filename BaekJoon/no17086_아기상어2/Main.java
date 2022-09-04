package BaekJoon.no17086_아기상어2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[][] map;
	static int row, col;
	static List<pos> shark = new ArrayList<pos>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		map = new int[row][col]; // 거리를 표시할 배열

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) {
					shark.add(new pos(i, j));
					map[i][j] = -1;
				}
			}
		}

		int many = shark.size();
		for (int i = 0; i < many; i++)
			bfs(i);

//		System.out.println(Arrays.stream(map).flatMapToInt(ans -> Arrays.stream(ans)).max().getAsInt());
		System.out.print(getMax());

		br.close();
	}

	private static int getMax() {
		int max = 0;
		for (int[] m : map) {
			for (int i : m)
				max = i > max ? i : max;
		}

		return max;
	}

	private static void bfs(int idx) {
		boolean[][] visited = new boolean[row][col];
		int depth = 1;

		pos start = shark.get(idx);
		Queue<pos> q = new LinkedList<pos>();
		q.offer(start);

		visited[start.x][start.y] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				pos cur = q.poll();

				for (int d = 0; d < 8; d++) {
					int cx = cur.x + dx[d];
					int cy = cur.y + dy[d];

					if (cx < 0 || cx >= row || cy < 0 || cy >= col || visited[cx][cy] || map[cx][cy] == -1)
						continue;

					if (map[cx][cy] == 0)
						map[cx][cy] = depth;
					else
						map[cx][cy] = Math.min(map[cx][cy], depth);

					visited[cx][cy] = true;
					q.offer(new pos(cx, cy));
				}
			}
			depth++;
		}
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
