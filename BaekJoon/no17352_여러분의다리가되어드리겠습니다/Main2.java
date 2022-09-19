package BaekJoon.no17352_여러분의다리가되어드리겠습니다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
	static int N;
	static boolean[] visited;
	static ArrayList<Integer>[] edge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		edge = new ArrayList[N];
		for (int i = 0; i < N; ++i)
			edge[i] = new ArrayList<>();

		// 간선 저장
		String str;
		while ((str = br.readLine()) != null && !str.equals("")) {
			st = new StringTokenizer(str);

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			// 양방향
			edge[a].add(b);
			edge[b].add(a);
		}

		// 0번 노드와 이어진 노드 true
		visited = new boolean[N];
		dfs(0);

		int dif = 0;
		boolean flag = visited[0];
		for (int i = 1; i < N; ++i) {
			if (visited[i] != flag) {
				dif = i;
				break;
			}
		}

		System.out.printf("%d %d", 1, dif + 1);
		br.close();
	}

	// DFS
	private static void dfs(int cur) {
		visited[cur] = true;
		for (int i : edge[cur]) {
			if (visited[i])
				continue;
			dfs(i);
		}
	}
}
