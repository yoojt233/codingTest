package BaekJoon.no2458_키순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 간선 수
		graph = new int[N][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int small = Integer.parseInt(st.nextToken()) - 1;
			int tall = Integer.parseInt(st.nextToken()) - 1;
			graph[small][tall] = 1;
			graph[tall][small] = 2;
		}

		for (int k = 0; k < N; k++) { // 경유지
			for (int i = 0; i < N; i++) { // 출발지
				if (i == k)
					continue;
				for (int j = 0; j < N; j++) { // 도착지
					if (i == j || k == j)
						continue;
					if (graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
						graph[j][i] = 2;
					}
				}
			}
		}
		
		System.out.print(getCnt());
		br.close();
	}

	private static int getCnt() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int temp = 0;
			for (int j = 0; j < N; j++) {
				if (graph[i][j] != 0)
					temp++;
			}
			if (temp == N - 1)
				cnt++;
		}
		return cnt;
	}
}
