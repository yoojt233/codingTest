package BaekJoon.no1219_오민식의고민_unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, A, B, M;
	static List<List<edge>> edges = new ArrayList<>();
	static int[] pay;
	static long money = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 도시 수
		A = Integer.parseInt(st.nextToken()); // 출발 도시
		B = Integer.parseInt(st.nextToken()); // 도착 도시
		M = Integer.parseInt(st.nextToken()); // 간선 수

		// edges 초기화
		for (int i = 0; i < N; i++)
			edges.add(new ArrayList<>());

		// 간선 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int val = -Integer.parseInt(st.nextToken());
			edges.get(from).add(new edge(to, val));
		}

		st = new StringTokenizer(br.readLine());
		pay = new int[N];
		for (int i = 0; i < N; i++)
			pay[i] = Integer.parseInt(st.nextToken());

		if (!bfs())
			System.out.print("gg");
		else {
			if(bellman_ford(A))
				System.out.print(money);
			else
				System.out.print("Gee");
		}

		br.close();
	}

	private static boolean bellman_ford(int start) {
		
		
		return false;
	}

	private static boolean bfs() {
		boolean[] visited = new boolean[N];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(A);
		visited[A] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == B)
				return true;

			for (edge e : edges.get(cur)) {
				if (visited[e.to] == true)
					continue;

				visited[e.to] = true;
				q.offer(e.to);
			}
		}

		return false;
	}
}

class edge {
	int to, val;

	public edge(int to, int val) {
		super();
		this.to = to;
		this.val = val;
	}
}