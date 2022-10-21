package BaekJoon.no25826_2차원배열다중업데이트단일합_unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int[] pos = new int[4];
			for (int j = 0; j < 4; ++j)
				pos[j] = Integer.parseInt(st.nextToken());
			int k = 0;
			if (cmd == 1) {
				k = Integer.parseInt(st.nextToken());
				execute(pos, k);
			} else
				System.out.print(execute(pos));
		}

		br.close();
	}

	private static void execute(int[] pos, int k) {
		for (int i = pos[0]; i <= pos[2]; ++i) {
			for (int j = pos[1]; j <= pos[3]; ++j)
				map[i][j] += k;
		}
	}

	private static long execute(int[] pos) {
		long sum = 0;
		for (int i = pos[0]; i <= pos[2]; ++i) {
			for (int j = pos[1]; j <= pos[3]; ++j)
				sum += map[i][j];
		}
		return sum;
	}
}
