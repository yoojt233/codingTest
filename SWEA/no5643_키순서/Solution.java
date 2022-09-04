package SWEA.no5643_키순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] graph;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine().trim());
			M = Integer.parseInt(br.readLine().trim());
			graph = new int[N][N];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int small = Integer.parseInt(st.nextToken()) - 1;
				int tall = Integer.parseInt(st.nextToken()) - 1;
				graph[small][tall] = 1; // 나보다 큰 사람들
				graph[tall][small] = 2; // 나보다 작은 사람들
			}

			for (int k = 0; k < N; k++) { // 경유지
				for (int i = 0; i < N; i++) { // 출발지
					if (i == k)
						continue;
					for (int j = 0; j < N; j++) { // 도착지
						if (i == j || k == j)
							continue;
						if (graph[i][k] == 1 && graph[k][j] == 1) { // 갈 수 있다면
							graph[i][j] = 1; // 나보다 크다.
							graph[j][i] = 2; // 나보다 작다.
						}
					}
				}
			}

			sb.append("#").append(t).append(" ").append(getCnt()).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static int getCnt() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int temp = 0;

			// 작은 사람 + 큰 사람 == 나 제외 나머지
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
