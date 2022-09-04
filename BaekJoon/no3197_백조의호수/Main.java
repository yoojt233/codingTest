package BaekJoon.no3197_백조의호수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int[] parents, goose;
	static char[][] map;
	static Queue<pos> melt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		init();

		int idx = 0;
		goose = new int[2];
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				char temp = s.charAt(j);
				map[i][j] = temp;
				if (temp == 'L') {
					goose[idx++] = i * c + j;
					map[i][j] = '.';
				}
			}
		}

		melt = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == '.') {
					getUnion(i, j);
					melt.offer(new pos(i, j));
				}
			}
		}

		int day = 0;
		while (!melt.isEmpty()) {
			if (find(goose[0]) == find(goose[1]))
				break;

			int size = melt.size();
			for (int i = 0; i < size; i++) {
				pos cur = melt.poll();

				for (int d = 0; d < 4; d++) {
					int cx = cur.x + dx[d];
					int cy = cur.y + dy[d];

					if (cx < 0 || cx >= r || cy < 0 || cy >= c || map[cx][cy] != 'X')
						continue;

					map[cx][cy] = '.';
					getUnion(cx, cy);
					melt.offer(new pos(cx, cy));
				}
			}
			++day;
		}

		System.out.print(day);
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void getUnion(int i, int j) {
		for (int d = 0; d < 4; d++) {
			int cx = i + dx[d];
			int cy = j + dy[d];

			if (cx < 0 || cx >= r || cy < 0 || cy >= c || map[cx][cy] != '.' || find(i * c + j) == find(cx * c + cy))
				continue;

			union(i * c + j, cx * c + cy);
		}
	}

	private static void init() {
		parents = new int[r * c];
		for (int i = 0; i < r * c; i++)
			parents[i] = i;
	}

	private static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		parents[bRoot] = aRoot;
	}
}

class pos {
	int x, y;

	public pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}