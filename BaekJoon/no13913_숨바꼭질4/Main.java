package BaekJoon.no13913_숨바꼭질4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[] pos = new int[100001];
	static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		int K = Integer.parseInt(st.nextToken()); // 동생 위치

		bfs(N, K);
		sb.append(visited[K] - 1).append("\n");

		Stack<Integer> path = new Stack<>();
		while (pos[K] != K) {
			path.add(K);
			K = pos[K];
		}
		path.add(N); // 출발 지점 추가

		while (!path.isEmpty())
			sb.append(path.pop()).append(" ");

		System.out.print(sb.toString());
		br.close();
	}

	private static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		pos[n] = n;
		visited[n] = 1;

		while (!q.isEmpty()) {
			int temp = q.poll();
			if (temp == k)
				return;

			if (temp - 1 >= 0 && visited[temp - 1] == 0) { // 1초 후 -1
				q.offer(temp - 1);
				visited[temp - 1] = visited[temp] + 1;
				pos[temp - 1] = temp;
			}

			if (temp + 1 <= 100000 && visited[temp + 1] == 0) { // 1초 후 +1
				q.offer(temp + 1);
				visited[temp + 1] = visited[temp] + 1;
				pos[temp + 1] = temp;
			}

			if (temp * 2 <= 100000 && visited[temp * 2] == 0) { // 1초 후 *2
				q.offer(temp * 2);
				visited[temp * 2] = visited[temp] + 1;
				pos[temp * 2] = temp;
			}
		}
	}
}
