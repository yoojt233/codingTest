package BaekJoon.no1068_트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static List<Integer>[] lists;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		lists = new List[N + 1];
		for (int i = 0; i < N + 1; ++i)
			lists[i] = new LinkedList<>();

		int[] parent = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			int p = Integer.parseInt(st.nextToken());
			p = p < 0 ? N : p;

			parent[i] = p;
			lists[p].add(i);
		}

		int R = Integer.parseInt(br.readLine());
		for (int i = 0; i < lists[parent[R]].size(); ++i) {
			if (lists[parent[R]].get(i) == R) {
				lists[parent[R]].remove(i);
				break;
			}
		}

		ans = 0;
		for (int i : lists[N])
			dfs(i);

		System.out.print(ans);
		br.close();
	}

	private static void dfs(int cur) {
		if (lists[cur].isEmpty()) {
			++ans;
			return;
		}

		for (int next : lists[cur])
			dfs(next);
	}
}
