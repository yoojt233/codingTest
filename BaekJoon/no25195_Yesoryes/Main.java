package BaekJoon.no25195_Yesoryes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int N, M, S;
	static HashSet<Integer> fans;
	static boolean flag;
	static ArrayList<Integer>[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점 수
		M = Integer.parseInt(st.nextToken()); // 간선 수

		edges = new ArrayList[N];
		for (int i = 0; i < N; ++i)
			edges[i] = new ArrayList<>();

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			edges[from].add(to);
		}

		S = Integer.parseInt(br.readLine());
		fans = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; ++i)
			fans.add(Integer.parseInt(st.nextToken()) - 1);

		flag = false;
		if (!fans.contains(0))
			dfs(0);
		System.out.print(flag ? "yes" : "Yes");
	}

	private static void dfs(int cur) {
		if (flag || edges[cur].isEmpty()) {
			flag = true;
			return;
		}

		for (int next : edges[cur]) {
			if (fans.contains(next))
				continue;
			dfs(next);
		}
	}
}

class node {
	int cur, next;

	public node(int cur, int next) {
		this.cur = cur;
		this.next = next;
	}
}