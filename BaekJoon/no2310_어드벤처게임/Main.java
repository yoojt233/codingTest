package BaekJoon.no2310_어드벤처게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static room[] rooms;
	static boolean[] visited;
	static boolean flag;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		while (N != 0) {
			rooms = new room[N];
			visited = new boolean[N];

			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				char info = st.nextToken().charAt(0);
				int cost = Integer.parseInt(st.nextToken());
				ArrayList<Integer> next = new ArrayList<>();
				int n = Integer.parseInt(st.nextToken());
				while (n != 0) {
					next.add(n - 1);
					n = Integer.parseInt(st.nextToken());
				}
				rooms[i] = new room(info, cost, next);
			}

			flag = false;
			dfs(0, 0);

			sb.append(flag ? "Yes" : "No").append("\n");
			N = Integer.parseInt(br.readLine());
		}
		System.out.print(sb);
		br.close();
	}

	private static void dfs(int where, int money) {
		if (rooms[where].info == 'L' && money < rooms[where].cost)
			money = rooms[where].cost;
		else if (rooms[where].info == 'T') {
			if (money < rooms[where].cost)
				return;
			money -= rooms[where].cost;
		}

		if (where == N - 1) {
			flag = true;
			return;
		}

		visited[where] = true;
		for (int next : rooms[where].next) {
			if (visited[next])
				continue;
			dfs(next, money);
		}
		visited[where] = false;
	}
}

class room {
	char info;
	int cost;
	ArrayList<Integer> next;

	public room(char info, int cost, ArrayList<Integer> next) {
		this.info = info;
		this.cost = cost;
		this.next = next;
	}
}