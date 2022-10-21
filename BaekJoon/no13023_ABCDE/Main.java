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

		// 간선 저장
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

		// 간선 수 체크
		if (K >= 4) {
			for (int i = 0; i < N; ++i) {
				if (flag) // 성공
					break;

				// 방문 체크
				boolean[] visited = new boolean[N];
				visited[i] = true;

				dfs(i, visited, 0);
			}
		}

		System.out.print(flag ? 1 : 0);
		br.close();
	}

	// 시작 위치, 방문 여부, 깊이
	private static void dfs(int cur, boolean[] visited, int level) {
		if (flag)
			return;

		// 깊이가 4는 친구 5명을 의미. (0부터 시작)
		if (level == 4) {
			flag = true;
			return;
		}

		if (level < 4) {
			for (int next : edge[cur]) {
				if (flag || visited[next])
					continue;

				visited[next] = true;
				dfs(next, visited, level + 1);
				visited[next] = false;
			}
		}
	}
}