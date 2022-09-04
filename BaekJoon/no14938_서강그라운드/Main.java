package BaekJoon.no14938_서강그라운드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, limit, r;
	static int[][] map;
	static int[] item;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], -1);
			map[i][i] = 0;
		}

		item = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			item[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int dist = Integer.parseInt(st.nextToken());

			map[from][to] = dist;
			map[to][from] = dist;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (i == k || map[i][k] == -1)
					continue;
				for (int j = 0; j < N; j++) {
					if (i == j || k == j || map[k][j] == -1)
						continue;
					int temp = map[i][k] + map[k][j];
					if (map[i][j] == -1 || map[i][j] > temp)
						map[i][j] = temp;
				}
			}
		}

		int ans = 0;
		for (int[] arr : map) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (0 <= arr[i] && arr[i] <= limit)
					cnt += item[i];
			}
			ans = Math.max(ans, cnt);
		}

		System.out.print(ans);
		br.close();
	}
}
