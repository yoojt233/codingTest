package BaekJoon.no9205_맥주마시면서걸어가기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean flag = false;

			pos[] position = new pos[N + 2];
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				position[i] = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), false);
			}

			// bfs
			Queue<pos> q = new LinkedList<pos>();
			q.offer(position[0]);
			position[0].visited = true;
			while (!q.isEmpty()) {
				pos cur = q.poll();

				if (cur.x == position[N + 1].x && cur.y == position[N + 1].y) {
					flag = true;
					break;
				}

				for (int i = 0; i < N + 2; i++) {
					if (position[i].visited || distance(cur, position[i]) > 1000)
						continue;

					q.offer(position[i]);
					position[i].visited = true;
				}
			}

			if (flag)
				sb.append("happy\n");
			else
				sb.append("sad\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static int distance(pos cur, pos next) {
		return Math.abs(cur.x - next.x) + Math.abs(cur.y - next.y);
	}
}

class pos {
	int x, y;
	boolean visited;

	public pos(int x, int y, boolean visited) {
		super();
		this.x = x;
		this.y = y;
		this.visited = visited;
	}
}