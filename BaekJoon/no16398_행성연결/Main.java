package BaekJoon.no16398_행성연결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		int[] value = new int[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j)
				map[i][j] = Integer.parseInt(st.nextToken());
			value[i] = Integer.MAX_VALUE;
		}

		long ans = 0;
		boolean[] visited = new boolean[N];
		value[0] = 0;
		for (int i = 0; i < N; ++i) {
			int min = Integer.MAX_VALUE;
			int node = 0;

			for (int j = 0; j < N; ++j) {
				if (!visited[j] && min > value[j]) {
					node = j;
					min = value[j];
				}
			}

			visited[node] = true;
			ans += min;

			for (int j = 0; j < N; ++j) {
				if (!visited[j] && map[node][j] != 0 && value[j] > map[node][j])
					value[j] = map[node][j];
			}
		}

		System.out.print(ans);
		br.close();
	}
}
