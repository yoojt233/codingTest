package BaekJoon.no16437_양구출작전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] island;
	static int[] sheep;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		island = new ArrayList[N];
		for (int i = 0; i < N; i++)
			island[i] = new ArrayList<>();

		sheep = new int[N];
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String animal = st.nextToken();
			int s = Integer.parseInt(st.nextToken());
			sheep[i] = animal.equals("W") ? -s : s;
			int to = Integer.parseInt(st.nextToken()) - 1;

			island[to].add(i);
		}

		System.out.println(dfs(0));
		br.close();
	}

	private static long dfs(int x) {
		long ans = 0;

		for (int to : island[x])
			ans += dfs(to);

		long temp = ans + sheep[x];
		if (sheep[x] > 0)
			return temp;
		else if (temp > 0)
			return temp;
		else
			return 0;
	}
}