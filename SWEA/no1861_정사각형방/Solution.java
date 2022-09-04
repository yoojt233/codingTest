package SWEA.no1861_정사각형방;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, cnt;
	static int[][] room;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int MAX;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input/SWEA/swea_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int t = 0; t < tc; t++) {

			N = Integer.parseInt(br.readLine()); // 방의 크기
			room = new int[N][N];
			MAX = Integer.MIN_VALUE;

			// 방에 값 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					room[i][j] = Integer.parseInt(st.nextToken());
			}

			int[] cntRoom = new int[N * N + 1];

			// 탐색 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 1;
					cntRoom[room[i][j]] = find(i, j);
				}
			}

			// 출력 부분
			sb.append("#").append(t + 1).append(" ");
			for (int i = 1; i < cntRoom.length; i++) {
				if (cntRoom[i] == MAX) {
					sb.append(i).append(" ");
					break;
				}
			}
			sb.append(MAX).append("\n");
		}
		System.out.print(sb.toString());
	}

	// 탐색 방법
	private static int find(int x, int y) {
		int current = room[x][y];
		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx >= 0 && cy >= 0 && cx < N && cy < N && (room[cx][cy] - current) == 1) {
				cnt++;
				find(cx, cy);
			}
		}
		MAX = Math.max(MAX, cnt);
		return cnt;
	}
}
