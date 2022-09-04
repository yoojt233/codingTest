package BaekJoon.no13549_숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] pos = new int[100001];
		Arrays.fill(pos, -1);

		bfs(pos, N, K);

		br.close();
	}

	private static void bfs(int[] pos, int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);

		pos[n] = 0;
		while (!q.isEmpty()) {
			int temp = q.poll();
			if (temp == k) {
				System.out.print(pos[temp]);
				return;
			}

			int next = temp * 2;
			while (next <= 100000 && pos[next] == -1) {
				pos[next] = pos[temp];
				q.offer(next);
				next *= 2;
			}

			if (temp - 1 >= 0 && pos[temp - 1] == -1) {
				pos[temp - 1] = pos[temp] + 1;
				q.add(temp - 1);
			}

			if (temp + 1 <= 100000 && pos[temp + 1] == -1) {
				pos[temp + 1] = pos[temp] + 1;
				q.add(temp + 1);
			}
		}
	}
}
