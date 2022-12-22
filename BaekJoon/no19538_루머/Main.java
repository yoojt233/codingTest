package BaekJoon.no19538_루머;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer>[] lists;
	static int[] ans, cnt;
	static Queue<Integer> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		lists = new List[N + 1];
		for (int i = 0; i < N + 1; ++i)
			lists[i] = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			int to = 0;
			while ((to = Integer.parseInt(st.nextToken())) != 0)
				lists[i + 1].add(to);
		}

		cnt = new int[N + 1];
		ans = new int[N + 1];
		Arrays.fill(ans, -1);

		int M = Integer.parseInt(br.readLine());
		q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			int cur = Integer.parseInt(st.nextToken());
			q.offer(cur);
			ans[cur] = 0;
		}

		bfs();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < N + 1; ++i)
			sb.append(ans[i] + " ");

		System.out.print(sb);
		br.close();
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; ++i) {
				int cur = q.poll();
				for (int next : lists[cur]) {
					if (ans[next] != -1 || ++cnt[next] < half(next))
						continue;

					q.offer(next);
					ans[next] = ans[cur] + 1;
				}
			}
		}
	}

	private static int half(int next) {
		int size = lists[next].size();
		return size % 2 == 0 ? size / 2 : size / 2 + 1;
	}
}
