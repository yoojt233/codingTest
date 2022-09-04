package BaekJoon.no1516_게임개발;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] end, time, first;
	static ArrayList<Integer>[] edge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 건물 수
		time = new int[N]; // 짓는데 걸리는 시간
		first = new int[N]; // 해당 건물을 짓기 위해 선행되어야 하는 건물 수

		edge = new ArrayList[N]; // 선행되어야 하는 건물 목록
		for (int i = 0; i < N; ++i)
			edge[i] = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());

				// -1은 끝을 의미
				if (temp != -1) {
					edge[temp - 1].add(i);
					++first[i];
				} else
					break;
			}
		}

		topologySort();

		for (int i : end)
			sb.append(i + "\n");

		System.out.print(sb);
		br.close();
	}

	// 위상 정렬
	private static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		end = new int[N];

		for (int i = 0; i < N; ++i) {
			end[i] = time[i]; // 기본 해당 건물을 짓는데 걸리는 시간

			// 선행이 필요없는 건물
			if (first[i] == 0)
				q.add(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i : edge[cur]) {
				end[i] = Math.max(end[i], end[cur] + time[i]);

				if (--first[i] == 0)
					q.add(i);
			}
		}
	}
}