package BaekJoon.no1463_1로만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] f;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		f = new int[N + 1];
		Arrays.fill(f, Integer.MAX_VALUE);
		f[1] = 0;
		bfs(N);

		br.close();
	}

	private static void bfs(int target) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		while (!q.isEmpty()) {
			int temp = q.poll();
			if (temp == target) {
				System.out.print(f[target]);
				break;
			}

			if (temp * 3 <= target && f[temp] + 1 < f[temp * 3]) {
				q.offer(temp * 3);
				f[temp * 3] = f[temp] + 1;
			}
			if (temp * 2 <= target && f[temp] + 1 < f[temp * 2]) {
				q.offer(temp * 2);
				f[temp * 2] = f[temp] + 1;
			}
			if (temp + 1 <= target && f[temp] + 1 < f[temp + 1]) {
				q.offer(temp + 1);
				f[temp + 1] = f[temp] + 1;
			}
		}
	}
}
