package BaekJoon.no1063_킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int kx, ky, rx, ry;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		// 킹의 x, y 좌표
		kx = input[0].charAt(0) - 'A';
		ky = input[0].charAt(1) - '1';

		// 돌의 x, y 좌표
		rx = input[1].charAt(0) - 'A';
		ry = input[1].charAt(1) - '1';

		int N = Integer.parseInt(input[2]); // 시행 횟수

		for (int i = 0; i < N; i++) {
			String act = br.readLine();
			move(act);
		}

		System.out.printf("%c%d\n%c%d", kx + 'A', ky + 1, rx + 'A', ry + 1);
		br.close();
	}

	static int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int[] dy = { 0, 0, -1, 1, 1, 1, -1, -1 };

	private static void move(String act) {
		switch (act) {
		case "R":
			to(0);
			break;
		case "L":
			to(1);
			break;
		case "B":
			to(2);
			break;
		case "T":
			to(3);
			break;
		case "RT":
			to(4);
			break;
		case "LT":
			to(5);
			break;
		case "RB":
			to(6);
			break;
		case "LB":
			to(7);
			break;
		}
	}

	private static void to(int dir) {
		int ckx = kx + dx[dir];
		int cky = ky + dy[dir];
		if (check(ckx, cky)) {
			if (ckx == rx && cky == ry) {
				int crx = rx + dx[dir];
				int cry = ry + dy[dir];
				if (check(crx, cry)) {
					rx = crx;
					ry = cry;
					kx = ckx;
					ky = cky;
				}
			} else {
				kx = ckx;
				ky = cky;
			}
		}
	}

	// 경계선 체크
	private static boolean check(int x, int y) {
		if (x >= 0 && x < 8 && y >= 0 && y < 8)
			return true;
		return false;
	}
}
