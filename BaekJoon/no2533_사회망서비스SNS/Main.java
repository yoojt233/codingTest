package BaekJoon.no2533_사회망서비스SNS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] graph;
	static int[][] dp;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		graph = new List[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken()) - 1;
			int ed = Integer.parseInt(st.nextToken()) - 1;

			// 양방향
			graph[op].add(ed);
			graph[ed].add(op);
		}

		dp = new int[2][N];
		visited = new boolean[N];
		dfs(0);

		System.out.println(Math.min(dp[0][0], dp[1][0]));
		br.close();
	}

	private static void dfs(int cur) {
		visited[cur] = true; // 방문 처리
		dp[0][cur] = 0; // adaptor 선택안함
		dp[1][cur] = 1; // adaptor 선택

		for (int next : graph[cur]) {
			if (visited[next])
				continue;

			dfs(next);

			// 내가 adaptor가 아니므로 자식이 adaptor여야만 한다.
			dp[0][cur] += dp[1][next];

			// 내가 adaptor이므로 자식은 adaptor여도 되고 아니어도 된다.
			dp[1][cur] += Math.min(dp[0][next], dp[1][next]);
		}
	}
}
