package BaekJoon.no25330_SHOWMETHEDUNGEON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[] monster, people;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int health = Integer.parseInt(st.nextToken());

		monster = new int[N];
		people = new int[N];
		for (int i = 0; i < 2; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				if (i == 0)
					monster[j] = Integer.parseInt(st.nextToken());
				else
					people[j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		visited = new boolean[N];
		permu(0, 0, 0, health);

		System.out.print(ans);
		br.close();
	}

	private static void permu(int cnt, int saved, int tired, int health) {
		if (cnt == N) {
			ans = Math.max(ans, saved);
			return;
		}
		
		ans = Math.max(ans, saved);

		for (int i = 0; i < N; ++i) {
			if (visited[i])
				continue;

			visited[i] = true;
			if (health - tired - monster[i] >= 0)
				permu(cnt + 1, saved + people[i], tired + monster[i], health - tired - monster[i]);
			visited[i] = false;
		}
	}
}