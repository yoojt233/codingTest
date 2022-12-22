package BaekJoon.no1707_이분그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static node[] nodes;
	static List<Integer>[] lists;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			flag = true;

			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			visited = new boolean[V];
			nodes = new node[V];
			for (int i = 0; i < V; ++i)
				nodes[i] = new node(i, 0);
			lists = new List[V];
			for (int i = 0; i < V; ++i)
				lists[i] = new ArrayList<>();

			for (int i = 0; i < E; ++i) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;

				lists[from].add(to);
				lists[to].add(from);
			}

			for (int i = 0; i < V; ++i) {
				visited[i] = true;
				dfs(i);

				if (!flag)
					break;
			}

			sb.append(flag ? "YES" : "NO").append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	private static void dfs(int cur) {
		if (!flag)
			return;

		for (int next : lists[cur]) {
			if (!visited[next]) {
				visited[next] = true;
				nodes[next].color = (nodes[cur].color + 1) % 2;
				dfs(next);
			} else if (nodes[next].color == nodes[cur].color) {
				flag = false;
				return;
			}
		}
	}
}

class node {
	int idx, color;

	public node(int idx, int color) {
		this.idx = idx;
		this.color = color;
	}
}