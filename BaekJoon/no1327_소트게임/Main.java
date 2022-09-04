package BaekJoon.no1327_소트게임;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int N, K;
	static int[] input;
	static HashSet<Integer> exist = new HashSet<Integer>(); // 시도

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 1부터 N까지
		input = new int[N];
		for (int i = 0; i < N; i++)
			input[i] = i + 1;

		// 목표
		int target = fullNum(input);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st.nextToken());

		System.out.print(bfs(target));
		br.close();
	}

	private static int bfs(int target) {
		int cnt = 0; // bfs 깊이
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(input);
		exist.add(fullNum(input)); // 시도해본 list에 추가

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();

				// 목표 달성 시 해당 깊이 return
				if (fullNum(cur) == target)
					return cnt;

				// 카드를 뒤집을 시작 위치는 0 번째 idx 부터 N-K 번째 idx까지
				for (int j = 0; j <= N - K; j++) {

					// 시작 위치부터 K개 만큼 뒤집기
					int[] next = exchange(cur, j, K + j - 1);
					int nextNum = fullNum(next);

					// 시도해본적 없다면
					if (!exist.contains(nextNum)) {
						q.offer(next);
						exist.add(nextNum);
					}
				}
			}
			++cnt;
		}

		return -1;
	}

	private static int[] exchange(int[] cur, int op, int ed) {

		// cur을 뒤집으면 다음 시도에 영향을 끼친다.
		int[] next = cur.clone();
		while (op < ed) {
			int temp = next[op];
			next[op++] = next[ed];
			next[ed--] = temp;
		}

		return next;
	}

	// 숫자들을 하나의 숫자로 합친다
	private static int fullNum(int[] input) {
		int sum = 0;
		for (int i = 0; i < N; i++)
			sum = sum * 10 + input[i];

		return sum;
	}
}
