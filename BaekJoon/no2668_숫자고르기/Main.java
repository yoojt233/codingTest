package BaekJoon.no2668_숫자고르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int[][] map;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		map = new int[2][N + 1];
		check = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			map[0][i] = i;
			map[1][i] = Integer.parseInt(br.readLine());
		}

		OUT: for (int i = 1; i <= N; i++) {
			boolean[] cop = check.clone();
			if (!check[i]) {
				List<Integer> upSet = new ArrayList<Integer>();
				List<Integer> downSet = new ArrayList<Integer>();
				dfs(i, upSet, downSet);
				Collections.sort(upSet);
				Collections.sort(downSet);

				for (int j = 0; j < upSet.size(); j++) {
					if (upSet.get(j) != downSet.get(j)) {
						check = cop;
						continue OUT;
					}
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (check[i]) {
				ans++;
				sb.append(i).append("\n");
			}
		}
		System.out.printf("%d\n", ans);
		System.out.print(sb.toString());
		br.close();
	}

	private static void dfs(int n, List<Integer> upSet, List<Integer> downSet) {
		if (!check[n]) {
			check[n] = true;
			upSet.add(n);
			downSet.add(map[1][n]);
			dfs(map[1][n], upSet, downSet);
		}
	}
}
