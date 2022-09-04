package JungOl.no1681_해밀턴순환회로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, MIN;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		MIN = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		dfs(0, new boolean[N], 0, 0);
		System.out.println(MIN);
		br.close();
	}

	private static void dfs(int cnt, boolean[] visited, int cur, int sum) {
		if (sum > MIN)
			return;

		if (cnt == N - 1) {
			if (map[cur][0] != 0 && sum + map[cur][0] < MIN)
				MIN = Math.min(sum + map[cur][0], MIN);
			return;
		}

		for (int i = 1; i < N; i++) {
			if (visited[i] || map[cur][i] == 0)
				continue;
			visited[i] = true;
			dfs(cnt + 1, visited, i, sum + map[cur][i]);
			visited[i] = false;
		}
	}
}
