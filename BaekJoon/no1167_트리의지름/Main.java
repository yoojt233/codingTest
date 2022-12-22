package BaekJoon.no1167_트리의지름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<node>[] lists;
	static int ans, maxIdx;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		lists = new List[N];
		for (int i = 0; i < N; ++i)
			lists[i] = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;

			while (to != -2) { // idx를 0부터 계산하므로 -1이 아닌 -2로 계산.
				int value = Integer.parseInt(st.nextToken());

				lists[from].add(new node(to, value));
				lists[to].add(new node(from, value));

				to = Integer.parseInt(st.nextToken()) - 1;
			}
		}

		ans = 0;
		maxIdx = 0;

		solve();
		if (maxIdx != 0)
			solve();

		System.out.print(ans);
		br.close();
	}

	private static void solve() {
		visited = new boolean[N];
		dfs(maxIdx, 0);
	}

	private static void dfs(int cur, int sum) {
		visited[cur] = true;
		for (node n : lists[cur]) {
			if (visited[n.idx])
				continue;

			dfs(n.idx, sum + n.value);
		}

		if (sum > ans) {
			maxIdx = cur;
			ans = sum;
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