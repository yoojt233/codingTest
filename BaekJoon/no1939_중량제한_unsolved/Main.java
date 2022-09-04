package BaekJoon.no1939_중량제한_unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 노드, 간선 정보
	static int[][] map; // 인접 행렬

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			// index가 0부터 시작하기 때문에 -1 처리
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int limit = Integer.parseInt(st.nextToken());

			limit = Math.max(limit, map[from][to]);
			map[from][to] = limit;
			map[to][from] = limit;
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(br.readLine());
		int end = Integer.parseInt(br.readLine());

		
		
		br.close();
	}
}
