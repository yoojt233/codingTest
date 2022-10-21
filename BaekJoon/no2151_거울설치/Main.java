package BaekJoon.no2151_거울설치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static char[][] map;
	static pos end;
	static PriorityQueue<pos> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		pq = new PriorityQueue<>();

		for (int i = 0; i < N; ++i) {
			String temp = br.readLine();
			for (int j = 0; j < N; ++j) {
				char c = temp.charAt(j);
				map[i][j] = c;
				if (c == '#') {
					if (pq.isEmpty()) {
						for (int d = 0; d < 4; ++d)
							pq.offer(new pos(i, j, 0, d));
					} else
						end = new pos(i, j, 0, 0);
				}
			}
		}

		System.out.println(bfs());
		br.close();
	}

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static int bfs() {
		while (!pq.isEmpty()) {
			pos cur = pq.poll();

			int cr = cur.r;
			int cc = cur.c;
			while (true) {
				cr += dx[cur.dir];
				cc += dy[cur.dir];

				if (cr < 0 || cr >= N || cc < 0 || cc >= N || map[cr][cc] == '*')
					break;

				if (cr == end.r && cc == end.c)
					return cur.mirror;

				if (map[cr][cc] == '!') {
					if (cur.dir == 0 || cur.dir == 2) {
						pq.offer(new pos(cr, cc, cur.mirror + 1, 1));
						pq.offer(new pos(cr, cc, cur.mirror + 1, 3));
					} else {
						pq.offer(new pos(cr, cc, cur.mirror + 1, 0));
						pq.offer(new pos(cr, cc, cur.mirror + 1, 2));
					}
				}
			}
		}
		return -1;
	}
}

class pos implements Comparable<pos> {
	int r, c, mirror, dir;

	public pos(int r, int c, int mirror, int dir) {
		this.r = r;
		this.c = c;
		this.mirror = mirror;
		this.dir = dir;
	}

	public int compareTo(pos o) {
		return this.mirror - o.mirror;
	}
}