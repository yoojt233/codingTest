package BaekJoon.no1240_노드사이의거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		dist = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(dist[i], 999999999);

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int val = Integer.parseInt(st.nextToken());

			dist[from][to] = val;
			dist[to][from] = val;
		}

		// 플로이드 - 와샬
		for (int k = 0; k < N; k++) { // 경유 지점
			for (int i = 0; i < N; i++) { // 출발 지점

				// 출발지와 경유지가 같으면 안된다.
				if (k == i)
					continue;
				for (int j = 0; j < N; j++) { // 도착 지점

					// 출발지와 경유지가 같거나, 경유지와 도착지가 같으면 안된다.
					if (i == j || j == k)
						continue;
					int temp = dist[i][k] + dist[k][j];
					if (temp < dist[i][j])
						dist[i][j] = temp;
				}
			}
		}

		// dist 배열에 모든 최단 거리가 저장되어 있다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			sb.append(dist[from][to] + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}