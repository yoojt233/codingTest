package BaekJoon.no11779_최소비용구하기2_unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] D; // 최단 경로 트리
	static boolean[] visited;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 도시 갯수
		int m = Integer.parseInt(br.readLine()); // 간선 갯수

		// 인접 행렬
		graph = new int[N][N];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			graph[from][to] = Integer.parseInt(st.nextToken());
		}

		// 출발과 도착
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;

		D = new int[N];
		visited = new boolean[N];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;

		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int cur = 0;
			for (int j = 0; j < N; j++) {
				if (!visited[j] && min > D[j]) {
					min = D[j];
					cur = j;
				}
			}

			visited[cur] = true;

			if (cur == end)
				break;

			for (int j = 0; j < N; j++) {
				if (!visited[j] && graph[cur][j] != 0 && D[j] > D[cur] + graph[cur][j])
					D[j] = D[cur] + graph[cur][j];
			}
		}

		sb.append(D[end]).append("\n");
		br.close();
	}
}