package BaekJoon.no1005_ACMCraft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] time, in, result;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine()); // 테스트 케이스
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 건물 수
			K = Integer.parseInt(st.nextToken()); // 주어지는 간선 수
			time = new int[N]; // 건물이 지어지는데 걸리는 시간

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				time[i] = Integer.parseInt(st.nextToken());

			list = new ArrayList[N]; // 간선 저장
			for (int i = 0; i < N; i++)
				list[i] = new ArrayList<Integer>();

			in = new int[N]; // 건물을 짓는데 필요한 선행 건물의 수
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;

				list[from].add(to);
				++in[to];
			}

			// 목표 건물
			int target = Integer.parseInt(br.readLine()) - 1;
			topologySort();
			sb.append(result[target] + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	// 위상 정렬
	private static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		result = new int[N];

		// 초기 드는 시간
		for (int i = 0; i < N; i++) {
			result[i] = time[i];

			if (in[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i : list[cur]) {

				// 여러 건물 중 가장 오래 걸리는 시간을 더해야하므로 max
				result[i] = Math.max(result[i], result[cur] + time[i]);

				// 선행 건물이 다 지어졌다면 Queue에 삽입
				if (--in[i] == 0)
					q.offer(i);
			}
		}
	}
}
