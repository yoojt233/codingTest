package BaekJoon.no14499_주사위굴리기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] map;
	static int[] dice;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		pos cur = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		dice = new int[7];
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			move(cur, Integer.parseInt(st.nextToken()) - 1);

		System.out.print(sb.toString());
		br.close();
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	private static void move(pos cur, int dir) {
		int cx = cur.x + dx[dir];
		int cy = cur.y + dy[dir];

		if (cx < 0 || cx >= N || cy < 0 || cy >= M)
			return;

		cur.x = cx;
		cur.y = cy;
		roll(dir);
		if (map[cx][cy] == 0)
			map[cx][cy] = dice[6];
		else {
			dice[6] = map[cx][cy];
			map[cx][cy] = 0;
		}

		sb.append(dice[1] + "\n");
	}

	private static void roll(int dir) {
		int temp = dice[1];
		switch (dir) {
		case 0:
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = temp;
			break;
		case 1:
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = temp;
			break;
		case 2:
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = temp;
			break;
		case 3:
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = temp;
			break;
		default:
			return;
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