package BaekJoon.no17406_배열돌리기4_unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R, cnt;
	static int[][] arr;
	static int[][] order;
	static int MIN;

	public static void main(String[] args) throws IOException {
		input();

		roll();

		// 각 행마다의 합
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < M; j++) {
				sum += arr[i][j];
			}
			MIN = Math.min(sum, MIN);
		}
	}

	private static void roll() {

		for (int i = 0; i < order.length; i++) {
			cnt = order[i][2];
			for (int j = 0; j < cnt; j++) {
				rotation(order[i][0] - order[i][2] - 1 + j, order[i][1] - order[i][2] - 1 + j,
						order[i][0] + order[i][2] - 1 - j, order[i][1] + order[i][2] - 1 - j); // 시작 x좌표, y좌표, 끝 x좌표,
																								// y좌표
			}
		}
	}

	private static void rotation(int sx, int sy, int ex, int ey) {

		int temp = arr[sx][sy];
		for (int i = sx; i < ex; i++)
			arr[i][sy] = arr[i + 1][sy];
		for (int i = sy; i < ey; i++)
			arr[ex][i] = arr[ex][i + 1];
		for (int i = ex; i > sx; i--)
			arr[i][ey] = arr[i - 1][ey];
		for (int i = ey; i > sy; i--)
			arr[sx][i] = arr[sx][i - 1];
		arr[sx][sy + 1] = temp;
	}

	private static void input() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer nmr = new StringTokenizer(br.readLine());
		N = Integer.parseInt(nmr.nextToken());
		M = Integer.parseInt(nmr.nextToken());
		R = Integer.parseInt(nmr.nextToken());

		arr = new int[N][M];
		order = new int[R][3];
		MIN = 0;

		// 배열 data 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		// 연산 실행 순서
		for (int i = 0; i < R; i++) {
			StringTokenizer rot = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				order[i][j] = Integer.parseInt(rot.nextToken());
		}
	}
}
