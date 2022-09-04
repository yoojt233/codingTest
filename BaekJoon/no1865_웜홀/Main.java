package BaekJoon.no1865_웜홀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, W;
	static List<List<edge>> edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			edges = new ArrayList<List<edge>>();
			for (int i = 0; i < N; i++)
				edges.add(new ArrayList<>());

			// 도로
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				int val = Integer.parseInt(st.nextToken());

				// 양방향
				edges.get(from).add(new edge(to, val));
				edges.get(to).add(new edge(from, val));
			}

			// 웜홀
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				edges.get(Integer.parseInt(st.nextToken()) - 1).add(new edge(Integer.parseInt(st.nextToken()) - 1, -Integer.parseInt(st.nextToken())));
			}

			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (bellman_ford(i)) {
					flag = true;
					sb.append("YES\n");
					break;
				}
			}
			if (!flag)
				sb.append("NO\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static boolean bellman_ford(int start) {
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		// N - 1번 실행
		for (int i = 1; i < N; i++) {
			boolean update = false;

			for (int j = 0; j < N; j++) {
				for (edge e : edges.get(j)) {
					if (dist[j] != Integer.MAX_VALUE && dist[e.to] > dist[j] + e.val) {
						dist[e.to] = dist[j] + e.val;
						update = true;
					}
				}
			}

			if (!update)
				return false;
		}

		// negative cycle 존재 유무 확인
		for (int i = 0; i < N; i++) {
			for (edge e : edges.get(i)) {
				if (dist[i] != Integer.MAX_VALUE && dist[e.to] > dist[i] + e.val)
					return true;
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
