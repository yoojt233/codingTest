package BaekJoon.no1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static Edge[] edge;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		edge = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			edge[i] = new Edge(st.nextToken(), st.nextToken(), st.nextToken());
		}
		Arrays.sort(edge);

		parents = new int[V];
		for (int i = 0; i < V; i++)
			parents[i] = i;

		long result = 0, cnt = 0;
		for (Edge e : edge) {
			if (union(e.from, e.to)) {
				result += e.val;
				if (++cnt == V - 1)
					break;
			}
		}

		System.out.print(result);
		br.close();
	}

	private static boolean union(int from, int to) {
		int aRoot = findSet(from - 1);
		int bRoot = findSet(to - 1);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int findSet(int from) {
		if (from == parents[from])
			return from;
		return parents[from] = findSet(parents[from]);
	}
}

class Edge implements Comparable<Edge> {
	int from, to, val;

	public Edge(String from, String to, String val) {
		super();
		this.from = Integer.parseInt(from);
		this.to = Integer.parseInt(to);
		this.val = Integer.parseInt(val);
	}

	@Override
	public int compareTo(Edge o) {
		return this.val - o.val;
	}
}