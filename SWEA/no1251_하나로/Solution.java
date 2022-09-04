package SWEA.no1251_하나로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static Position[] island;
	static long[][] adjMatrix;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine()); // 섬의 개수
			island = new Position[N];
			StringTokenizer ix = new StringTokenizer(br.readLine()); // x 좌표
			StringTokenizer iy = new StringTokenizer(br.readLine()); // y 좌표
			double E = Double.parseDouble(br.readLine()); // 환경 부담 세율
			adjMatrix = new long[N][N];

			// 섬 좌표
			for (int i = 0; i < N; i++)
				island[i] = new Position(ix.nextToken(), iy.nextToken());

			// 섬 간의 거리
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					adjMatrix[i][j] = adjMatrix[j][i] = (long) (Math.pow(island[i].x - island[j].x, 2)
							+ Math.pow(island[i].y - island[j].y, 2));
				}
			}

			long[] minEdge = new long[N];
			boolean[] visited = new boolean[N];
			Arrays.fill(minEdge, Long.MAX_VALUE);

			long result = 0;
			minEdge[0] = 0;
			for (int c = 0; c < N; c++) {
				long min = Long.MAX_VALUE;
				int minVertex = 0;

				for (int i = 0; i < N; i++) {
					if (!visited[i] && min > minEdge[i]) {
						min = minEdge[i];
						minVertex = i;
					}
				}

				visited[minVertex] = true;
				result += min;

				for (int i = 0; i < N; i++) {
					if (!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i])
						minEdge[i] = adjMatrix[minVertex][i];
				}

			}
			sb.append(Math.round(result * E)).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	public static class Position {
		int x, y;

		public Position(String x, String y) {
			super();
			this.x = Integer.parseInt(x);
			this.y = Integer.parseInt(y);
		}
	}
}
