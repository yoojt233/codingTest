package BaekJoon.no1325_효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] possible;
	static List<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()); // 노드 수
		int m = Integer.parseInt(st.nextToken()); // 간선 수
		possible = new int[N + 1]; // 각 컴퓨터 마다 해킹 가능한 수
		int max = Integer.MIN_VALUE;
		adjList = new ArrayList[N + 1]; // 인접리스트 배열 초기화

		for (int i = 0; i <= N; i++)
			adjList[i] = new ArrayList<Integer>(); // 각 리스트 초기화

		// 간선 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			adjList[to].add(from);
		}

		// dfs 탐색 시작
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			dfs(i);
		}

		for (int i : possible)
			max = Math.max(i, max);

		// 최대가 되는 시작점
		for (int i = 1; i <= N; i++) {
			if (max == possible[i])
				sb.append(i).append(" ");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void dfs(int from) {
		visited[from] = true;
		for (int i : adjList[from])
			if (!visited[i]) {
				possible[i]++;
				dfs(i);
			}
	}
}
