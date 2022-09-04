package BaekJoon.no11403_경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					bfs(i, j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] check = new boolean[N];

		q.offer(end);
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < N; i++) {
				if (map[temp][i] == 1 && !check[i]) {
					q.offer(i);
					map[start][i] = 1;
					check[i] = true;
				}
			}
		}
	}
}
