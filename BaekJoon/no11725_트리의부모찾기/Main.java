package BaekJoon.no11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		List<Integer>[] tree = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; ++i)
			tree[i] = new ArrayList<>();
		tree[0].add(1);

		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree[a].add(b);
			tree[b].add(a);
		}

		int[] parent = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : tree[cur]) {
				if (visited[next])
					continue;
				visited[next] = true;
				parent[next] = cur;
				q.add(next);
			}
		}

		for (int i = 2; i < N + 1; ++i)
			sb.append(parent[i] + "\n");

		System.out.print(sb);
		br.close();
	}
}
