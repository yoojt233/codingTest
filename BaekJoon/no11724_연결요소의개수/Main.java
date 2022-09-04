package BaekJoon.no11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, edge, cnt;
	static int graph[][];
	static boolean check[];

	public static void main(String[] args) throws IOException {
		input();
		
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				dfs(i);
				cnt++;
			}
		}

		System.out.println(cnt);

	}

	private static void dfs(int start) {
		if (check[start]) {
			return;
		}
		check[start] = true;
		for (int i = 1; i <= N; i++) {
			if (graph[start][i] == 1)
				dfs(i);
		}
	}

	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());

		graph = new int[N + 1][N + 1];

		for (int i = 0; i < edge; i++) {
			StringTokenizer value = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(value.nextToken());
			int y = Integer.parseInt(value.nextToken());
			graph[x][y] = graph[y][x] = 1;
		}

		cnt = 0;
		check = new boolean[N + 1];
	}
}
