package BaekJoon.no1967_트리의지름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<node>[] list;
	static boolean[] visited;
	static int ans, maxIdx;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new List[N];

		for (int i = 0; i < N; ++i)
			list[i] = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int value = Integer.parseInt(st.nextToken());

			list[from].add(new node(to, value));
			list[to].add(new node(from, value));
		}

		ans = 0;
		maxIdx = 0;
		visited = new boolean[N];
		dfs(0, 0);
		
		if (maxIdx != 0) {
			visited = new boolean[N];
			dfs(maxIdx, 0);
		}

		System.out.print(ans);
		br.close();
	}

	private static void dfs(int cur, int sum) {
		visited[cur] = true;
		for (node n : list[cur]) {
			if (!visited[n.idx])
				dfs(n.idx, sum + n.value);
		}

		if (sum > ans) {
			ans = sum;
			maxIdx = cur;
		}
	}
}

class node {
	int idx, value;

	public node(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}
}