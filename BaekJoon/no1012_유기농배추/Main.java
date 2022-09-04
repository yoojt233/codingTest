package BaekJoon.no1012_유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M, N, K, worm; // 가로 세로 배추 지렁이
	static int[][] farm;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			worm = 0;

			String[] input;
			farm = new int[M][N];
			for (int i = 0; i < K; i++) {
				input = br.readLine().split(" ");
				farm[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (farm[i][j] == 1) {
						dfs(i, j);
						worm++;
					}
				}
			}
			sb.append(worm).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static void dfs(int x, int y) {
		farm[x][y] = 2;

		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx >= 0 && cy >= 0 && cx < M && cy < N && farm[cx][cy] == 1) {
				dfs(cx, cy);
			}
		}
	}
}
