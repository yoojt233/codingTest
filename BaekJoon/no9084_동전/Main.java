package BaekJoon.no9084_동전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine()); // 동전 가지 수
			int[] coins = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				coins[i] = Integer.parseInt(st.nextToken());

			int M = Integer.parseInt(br.readLine()); // 목표 금액

			// 0원을 낼 수 있는 가지 수를 1로 초기화
			int[][] ways = new int[N + 1][M + 1];
			for (int i = 0; i <= N; i++)
				ways[i][0] = 1;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {

					// coins[i] 보다 높은 금액이라면, 윗 값 + (j - coins[i])의 값
					if (j >= coins[i])
						ways[i][j] = ways[i - 1][j] + ways[i][j - coins[i]];

					// 낮다면 윗 값을 그대로 내린다.
					else
						ways[i][j] = ways[i - 1][j];
				}
			}

			sb.append(ways[N][M] + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}
