package BaekJoon.no1686_복날;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int v, m;
	static pos[] input;
	static ArrayList<pos> bunker;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		input = new pos[2];
		for (int i = 0; i < 2; ++i) {
			st = new StringTokenizer(br.readLine());
			input[i] = new pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), 0);
		}

		bunker = new ArrayList<pos>();
		String str;
		while ((str = br.readLine()) != null && !str.isEmpty()) {
			st = new StringTokenizer(str);
			bunker.add(new pos(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), 0));
		}
		bunker.add(input[1]);

		visited = new boolean[bunker.size()];
		int ans = bfs();

		if (ans == -1)
			System.out.print("No.");
		else
			System.out.printf("Yes, visiting %d other holes.", ans);
		br.close();
	}

	private static int bfs() {
		Queue<pos> q = new LinkedList<pos>();
		q.offer(input[0]);

		while (!q.isEmpty()) {
			pos cur = q.poll();

			// 탈출
			if (cur.x == input[1].x && cur.y == input[1].y)
				return cur.cnt - 1;

			for (int i = 0; i < visited.length; ++i) {
				if (visited[i])
					continue;

				pos next = bunker.get(i);
				if (dist(cur, next) <= v * 60 * m) {
					next.cnt = cur.cnt + 1;
					q.offer(next);
					visited[i] = true;
				}
			}
		}

		return -1;
	}

	private static double dist(pos cur, pos next) {
		double dx = Math.abs(next.x - cur.x);
		double dy = Math.abs(next.y - cur.y);
		return Math.sqrt(dx * dx + dy * dy);
	}
}

class pos {
	double x, y;
	int cnt;

	public pos(double x, double y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}