package BaekJoon.no1240_노드사이의거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	static int N;
	static List<node>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new List[N + 1]; // 인접리스트
		for (int i = 0; i < N + 1; i++)
			list[i] = new ArrayList<node>();

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());

			// 양방향
			list[from].add(new node(to, val));
			list[to].add(new node(from, val));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			sb.append(bfs(from, to) + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static int bfs(int from, int to) {

		// 방문 여부
		boolean[] visited = new boolean[N + 1];

		Queue<node> q = new LinkedList<node>();
		q.offer(new node(from, 0));
		visited[from] = true;

		while (!q.isEmpty()) {
			node cur = q.poll();
			
			// 도착
			if (cur.to == to)
				return cur.val;

			for (node n : list[cur.to]) {
				if (visited[n.to])
					continue;
				q.offer(new node(n.to, cur.val + n.val));
				visited[n.to] = true;
			}
		}

		return 0;
	}
}

// 도착 지점, 가중치
class node {
	int to, val;

	public node(int to, int val) {
		super();
		this.to = to;
		this.val = val;
	}
}