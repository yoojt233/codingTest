package BaekJoon.no21610_마법사상어와비바라기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, total;
	static pos[] map;
	static Queue<pos> before, after; // 구름 이동 전, 이동 후

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		map = new pos[N * N];
		before = new LinkedList<pos>();
		after = new LinkedList<pos>();
		total = 0; // 존재하는 물의 양 총합

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i * N + j] = new pos(i, j, Integer.parseInt(st.nextToken()), false);
				total += map[i * N + j].water;
			}
		}

		// 초기 구름
		for (int i = N - 2; i < N; i++) {
			for (int j = 0; j < 2; j++)
				before.offer(map[i * N + j]);
		}

		for (int i = 0; i < Integer.parseInt(input[1]); i++) {
			st = new StringTokenizer(br.readLine());
			move(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			bug();
			init();
		}

		System.out.print(total);
		br.close();
	}

	// 구름 초기화
	private static void init() {
		for (int i = 0; i < N * N; i++) {
			if (map[i].status) // 이미 구름이 있던 곳은 false로
				map[i].status = false;
			else if (map[i].water >= 2) { // 물이 2이상 있다면 구름이 생긴다
				map[i].water -= 2;
				total -= 2;
				before.offer(map[i]);
			}
		}
	}

	static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	// 구름의 이동 방향과 속도
	private static void move(int d, int s) {
		while (!before.isEmpty()) {
			pos cur = before.poll();

			// 이동 후 좌표
			int cx = range(cur.x + dx[d] * s);
			int cy = range(cur.y + dy[d] * s);

			// 이동 한 곳에는 비가 내려 물의 양이 1 증가, 이미 이동한 구름
			map[cx * N + cy] = new pos(cx, cy, map[cx * N + cy].water + 1, true);
			total += 1;

			// 구름이 존재했던 곳
			after.offer(map[cx * N + cy]);
		}
	}

	// 좌표 재조정
	private static int range(int temp) {
		if (temp < 0)
			return range(temp + N);
		else if (temp >= N)
			return temp % N;
		return temp;
	}

	// 대각선 탐색
	private static void bug() {
		while (!after.isEmpty()) {
			pos cur = after.poll();

			int cnt = 0;
			for (int d = 2; d <= 8; d += 2) {
				int cx = cur.x + dx[d];
				int cy = cur.y + dy[d];

				if (cx < 0 || cx >= N || cy < 0 || cy >= N)
					continue;

				// 해당 방향에 물이 있다면
				if (map[cx * N + cy].water > 0)
					cnt++;
			}
			map[cur.x * N + cur.y].water += cnt;
			total += cnt;
		}
	}
}

class pos {
	int x, y, water;
	boolean status;

	public pos(int x, int y, int water, boolean status) {
		this.x = x;
		this.y = y;
		this.water = water;
		this.status = status;
	}
}
