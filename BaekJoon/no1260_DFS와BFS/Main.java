package BaekJoon.no1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] graph;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken()); // 노드 수
		M = Integer.parseInt(st.nextToken()); // 간선 수
		int V = Integer.parseInt(st.nextToken()); // 시작 노드

		graph = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");
			graph[Integer.parseInt(input[0])][Integer
					.parseInt(input[1])] = graph[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
		}

		dfs(V, new boolean[N + 1]);
		sb.append("\n");
		bfs(V);
		System.out.print(sb.toString());
		br.close();
	}

	// BFS 넓이우선탐색
	private static void bfs(int v) {
		boolean[] number = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(v);
		number[v] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			sb.append(temp).append(" ");
			for (int i = 1; i <= N; i++) {
				if (graph[temp][i] == 1 && number[i] == false) {
					q.offer(i);
					number[i] = true;
				}
			}
		}
	}

	// DFS 깊이우선탐색
	private static void dfs(int v, boolean[] check) {
		sb.append(v).append(" ");
		check[v] = true;

		for (int i = 1; i <= N; i++) {
			if (graph[v][i] == 1 && check[i] == false) {
				dfs(i, check);
			}
		}
	}
}
