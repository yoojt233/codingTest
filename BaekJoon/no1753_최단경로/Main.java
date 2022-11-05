package BaekJoon.no1753_최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static ArrayList<node>[] edges;
	static int[] ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		int op = Integer.parseInt(br.readLine()) - 1;
		edges = new ArrayList[V];
		for (int i = 0; i < V; ++i)
			edges[i] = new ArrayList<>();

		ans = new int[V];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[op] = 0;

		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int val = Integer.parseInt(st.nextToken());

			edges[from].add(new node(to, val));
		}

		dijk(op);

		for (int i : ans)
			sb.append(i == Integer.MAX_VALUE ? "INF" : i).append("\n");

		System.out.print(sb);
		br.close();
	}

	private static void dijk(int op) {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(op, 0));
		boolean[] visited = new boolean[V];

		while (!pq.isEmpty()) {
			node cur = pq.poll();

			if (visited[cur.next])
				continue;

			visited[cur.next] = true;
			for (node n : edges[cur.next]) {
				if (ans[n.next] > ans[cur.next] + n.value) {
					ans[n.next] = ans[cur.next] + n.value;
					pq.add(new node(n.next, ans[n.next]));
				}
			}
		}
	}
}

class node implements Comparable<node> {
	int next, value;

	public node(int next, int value) {
		this.next = next;
		this.value = value;
	}

	public int compareTo(node o) {
		return this.value - o.value;
	}
}