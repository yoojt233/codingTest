package BaekJoon.no13023_ABCDE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean flag = false;
	static ArrayList<Integer>[] edge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		edge = new ArrayList[N];
		for (int i = 0; i < N; ++i)
			edge[i] = new ArrayList<>();

		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			edge[a].add(b);
			edge[b].add(a);
		}

		if (K >= 4) {
			for (int i = 0; i < N; ++i) {
				if (flag)
					break;

				boolean[] visited = new boolean[N];
				visited[i] = true;
				dfs(i, visited, 0, 1);
			}
		}

		System.out.print(flag ? 1 : 0);
		br.close();
	}

	private static void dfs(int cur, boolean[] visited, int level, int check) {
		if (flag)
			return;

		if (check == 5)
			flag = true;

		if (level < 4) {
			for (int next : edge[cur]) {
				if (flag || visited[next])
					continue;

				visited[next] = true;
				dfs(next, visited, level + 1, check + 1);
				visited[next] = false;
			}
		}
	}
}