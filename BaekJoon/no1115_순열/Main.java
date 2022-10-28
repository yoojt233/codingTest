package BaekJoon.no1115_순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean[] visited;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");

		visited = new boolean[N];
		p = new int[N];
		for (int i = 0; i < N; ++i)
			p[i] = Integer.parseInt(temp[i]);

		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			if (visited[i])
				continue;
			++cnt;
			cycle(i);
		}

		System.out.print(cnt != 1 ? cnt : 0);
		br.close();
	}

	private static void cycle(int x) {
		visited[x] = true;

		if (visited[p[x]])
			return;
		cycle(p[x]);
	}
}
