package BaekJoon.no5014_스타트링크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int end = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());

		// 엘레베이터
		int[] ev = new int[end + 1];
		boolean[] visited = new boolean[end + 1];

		int ans = Integer.MAX_VALUE;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[0] = true; // 0층은 없으므로 true 처리
		visited[start] = true; // 시작층 true 처리

		while (!q.isEmpty()) {
			int cur = q.poll();

			// 목표 도달
			if (cur == goal) {
				ans = ev[cur];
				break;
			}

			// up
			if (cur + up <= end && !visited[cur + up]) {
				ev[cur + up] = ev[cur] + 1;
				visited[cur + up] = true;
				q.add(cur + up);
			}

			// down
			if (cur - down > 0 && !visited[cur - down]) {
				ev[cur - down] = ev[cur] + 1;
				visited[cur - down] = true;
				q.add(cur - down);
			}
		}

		if (ans != Integer.MAX_VALUE)
			System.out.print(ans);
		else
			System.out.print("use the stairs");

		br.close();
	}
}
