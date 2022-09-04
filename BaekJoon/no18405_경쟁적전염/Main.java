package BaekJoon.no18405_경쟁적전염;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static virus[][] map;
	static PriorityQueue<virus> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new virus[N][N];
		pq = new PriorityQueue<>();

		// 입력 중 바이러스 판단
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp != 0) {
					virus v = new virus(temp, i, j, false);
					map[i][j] = v;
					pq.add(v);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		int sec = Integer.parseInt(st.nextToken()); // 목표 시간
		int tx = Integer.parseInt(st.nextToken()) - 1; // 목표 x 좌표
		int ty = Integer.parseInt(st.nextToken()) - 1; // 목표 y 좌표

		while (sec-- > 0) {
			spread();
			init();

			// 이미 선택한 구역에 바이러스가 퍼졌다면 더 이상 진행할 필요x
			if (map[tx][ty] != null)
				break;
		}

		// 해당 구역에 바이러스 여부 판단
		if (map[tx][ty] != null)
			System.out.print(map[tx][ty].num);
		else
			System.out.print(0);
		br.close();
	}


	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void spread() {
		while (!pq.isEmpty()) {
			
			// 번호가 작은 바이러스부터
			virus cur = pq.poll();
			cur.status = true;

			for (int d = 0; d < 4; d++) {
				int cx = cur.x + dx[d];
				int cy = cur.y + dy[d];

				if (cx < 0 || cx >= N || cy < 0 || cy >= N || map[cx][cy] != null)
					continue;

				map[cx][cy] = new virus(cur.num, cx, cy, false);
			}
		}
	}

	// PriorityQueue에 새로 바이러스 삽입
	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != null && !map[i][j].status)
					pq.add(map[i][j]);
			}
		}
	}
}

// 바이러스 번호, 좌표, 이미 확산된 바이러스?
class virus implements Comparable<virus> {
	int num, x, y;
	boolean status;

	public virus(int num, int x, int y, boolean status) {
		super();
		this.num = num;
		this.x = x;
		this.y = y;
		this.status = status;
	}

	@Override
	public int compareTo(virus o) {
		return this.num - o.num;
	}
}