package SWEA.no1263_사람네트워크2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] graph = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					if (graph[i][j] == 0)
						graph[i][j] = 999999999;
				}
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k)
						continue;
					for (int j = 0; j < N; j++) {
						if (i == j || j == k)
							continue;
						if (graph[i][j] > graph[i][k] + graph[k][j])
							graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}

			sb.append("#").append(t).append(" ").append(minimum(graph, N)).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static int minimum(int[][] graph, int N) {
		int[] CC = new int[N];
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				sum += graph[i][j];
			}
			CC[i] = sum;
		}

		Arrays.sort(CC);

		return CC[0];
	}
}
