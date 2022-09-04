package BaekJoon.no1956_운동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] map = new int[V][V];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int val = Integer.parseInt(st.nextToken());

			map[from][to] = val;
		}

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < V; j++) {
					if (k == j || map[i][k] == 0 || map[k][j] == 0)
						continue;
					if (map[i][j] > map[i][k] + map[k][j] || map[i][j] == 0)
						map[i][j] = map[i][k] + map[k][j];
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < V; i++) {
			if (map[i][i] == 0)
				continue;
			ans = Integer.min(ans, map[i][i]);
		}

		if (ans == Integer.MAX_VALUE)
			ans = -1;

		System.out.print(ans);
		br.close();
	}
}
