package BaekJoon.no17143_낚시왕;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int row, col, M, sum;
	static shark[][][] map;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, 1, -1 };
	static PriorityQueue<shark> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken()); // 행
		col = Integer.parseInt(st.nextToken()); // 열, 상어를 잡을 기회
		M = Integer.parseInt(st.nextToken()); // 상어 마리 수
		map = new shark[col + 1][row][col];
		pq = new PriorityQueue<shark>();
		sum = 0;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			if (d < 3)
				speed %= (row - 1) * 2;
			else
				speed %= (col - 1) * 2;

			map[0][x][y] = new shark(x, y, speed, d, size);
		}

		for (int time = 0; time < col; time++) {

			// 상어 잡아라!
			for (int i = 0; i < row; i++) {
				if (map[time][i][time] != null) {
					sum += map[time][i][time].size;
					map[time][i][time] = null;
					break;
				}
			}

			if (time == col - 1)
				break;

			getShark(time);

			move(time);

		}

		System.out.print(sum);
		br.close();
	}

	private static void getShark(int time) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (map[time][i][j] == null)
					continue;
				pq.add(map[time][i][j]);
			}
		}
	}

	private static void move(int time) {
		while (!pq.isEmpty()) {
			shark cur = pq.poll();

			int cx = cur.x;
			int cy = cur.y;
			for (int sec = 0; sec < cur.speed; sec++) {
				cx += dx[cur.d];
				cy += dy[cur.d];

				// 끝에 다다르면 방향전환
				if (cx < 0 || cx >= row || cy < 0 || cy >= col) {
					if (cur.d % 2 == 1)
						cur.d += 1;
					else
						cur.d -= 1;

					cx += dx[cur.d] * 2;
					cy += dy[cur.d] * 2;
				}
			}

			if (map[time + 1][cx][cy] == null)
				map[time + 1][cx][cy] = new shark(cx, cy, cur.speed, cur.d, cur.size);
		}
	}
}

class shark implements Comparable<shark> {
	int x, y, speed, d, size;

	public shark(int x, int y, int speed, int d, int size) {
		super();
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.d = d;
		this.size = size;
	}

	@Override
	public String toString() {
		return "shark [x=" + x + ", y=" + y + ", speed=" + speed + ", d=" + d + ", size=" + size + "]";
	}

	@Override
	public int compareTo(shark o) {
		return o.size - this.size;
	}
}