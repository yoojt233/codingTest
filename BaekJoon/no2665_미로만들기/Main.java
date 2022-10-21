package BaekJoon.no2665_미로만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int N;
	static char[][] map;
	static pos[][] room;
	static PriorityQueue<pos> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		room = new pos[N][N];
		pq = new PriorityQueue<>();

		for (int i = 0; i < N; ++i)
			map[i] = br.readLine().toCharArray();

		room[0][0] = new pos(0, 0, 0);
		pq.offer(room[0][0]);

		System.out.print(maze());
		br.close();
	}

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	private static int maze() {
		while (!pq.isEmpty()) {
			pos cur = pq.poll();

			for (int d = 0; d < 4; ++d) {
				int cr = cur.r + dr[d];
				int cc = cur.c + dc[d];

				if (cr == N - 1 && cc == N - 1)
					return cur.wall;

				if (cr < 0 || cr >= N || cc < 0 || cc >= N)
					continue;

				if (map[cr][cc] == '1') {
					if (room[cr][cc] != null && room[cr][cc].wall <= cur.wall)
						continue;
					room[cr][cc] = new pos(cr, cc, cur.wall);
					pq.offer(room[cr][cc]);
				} else {
					if (room[cr][cc] != null && room[cr][cc].wall <= cur.wall + 1)
						continue;
					room[cr][cc] = new pos(cr, cc, cur.wall + 1);
					pq.offer(room[cr][cc]);
				}
			}
		}
		return -1;
	}
}

class pos implements Comparable<pos> {
	int r, c, wall;

	public pos(int r, int c, int wall) {
		this.r = r;
		this.c = c;
		this.wall = wall;
	}

	public int compareTo(pos o) {
		return this.wall - o.wall;
	}
}