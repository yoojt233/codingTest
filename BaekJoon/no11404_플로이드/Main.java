package BaekJoon.no11404_플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 도시 수
		int m = Integer.parseInt(br.readLine()); // 간선 수
		int[][] cities = new int[n][n];

		// 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());

			cities[from][to] = cities[from][to] == 0 ? cost : Math.min(cities[from][to], cost);
		}

		// 플로이드-와샬
		for (int k = 0; k < n; k++) { // 경유지
			for (int i = 0; i < n; i++) { // 출발지

				// 1. 경유지와 출발지가 같음 // 2. 출발지에서 경유지로 가는 버스가 없음
				if (k == i || cities[i][k] == 0)
					continue;
				for (int j = 0; j < n; j++) { // 도착지

					// 1. 경유지와 도착지가 같음 // 2. 출발지와 도착지가 같음 // 3. 경유지에서 도착지까지 가는 버스가 없음
					if (k == j || i == j || cities[k][j] == 0)
						continue;
					int temp = cities[i][k] + cities[k][j];
					cities[i][j] = cities[i][j] == 0 ? temp : Math.min(cities[i][j], temp);
				}
			}
		}

		// 출력
		for (int[] city : cities) {
			for (int i : city)
				sb.append(i + " ");
			sb.append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}
