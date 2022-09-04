package BaekJoon.no17471_게리맨더링;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, sum;
	static int[] population;
	static boolean[][] graph;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 구역의 수
		sum = 0; // 인구 수 총합
		population = new int[N]; // 지역 별 인구 수

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			population[i] = temp;
			sum += temp;
		}

		graph = new boolean[N][N]; // 그래프

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k > 0) {
				for (int j = 0; j < k; j++) {
					int to = Integer.parseInt(st.nextToken());
					graph[i][to - 1] = graph[to - 1][i] = true; // 방향 x
				}
			}
		}

		subset(0, 0, new boolean[N]);

		// ans가 변경되지 않았다면 불가능하다는 뜻
		if (ans == Integer.MAX_VALUE)
			ans = -1;

		System.out.print(ans);
	}

	private static void subset(int cnt, int sel, boolean[] which) {
		if (cnt == N) {
			if (sel == 0 || sel == sum)
				return;
			if (bfs(which)) {
				
				// 구역 1: sel, 구역 2: (sum- sel), |구역1 - 구역2|
				ans = Math.min(ans, Math.abs(2 * sel - sum));
			}
			return;
		}

		which[cnt] = true; // 선택했을 경우
		subset(cnt + 1, sel + population[cnt], which);

		which[cnt] = false; // 선택하지 않았을 경우
		subset(cnt + 1, sel, which);
	}

	private static boolean bfs(boolean[] which) {
		boolean[] check = new boolean[N]; // 방문 여부

		int left = 0, right = 0;
		for (int i = 0; i < N; i++) {
			if (which[i])
				left = i; // 구역1
			else
				right = i; // 구역 2
		}

		// 구역 1 연결 검사
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(left);
		check[left] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < N; i++) {

				// 방문x, 구역 1, 연결o
				if (!check[i] && which[i] && graph[temp][i]) {
					q.offer(i);
					check[i] = true;
				}
			}
		}

		// 구역 2 연결 검사
		q.offer(right);
		check[right] = true;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < N; i++) {

				// 방문x, 구역 2, 연결o
				if (!check[i] && !which[i] && graph[temp][i]) {
					q.offer(i);
					check[i] = true;
				}
			}
		}

		// 구역 1부분도 true, 구역 2부분도 true로 바꿨으니
		// 모두 true여야 한다.
		for (int i = 0; i < N; i++) {
			if (!check[i])
				return false;
		}

		return true;
	}
}
