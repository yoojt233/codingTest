package BaekJoon.no25195_Yesoryes_unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 정점 수
		int M = Integer.parseInt(st.nextToken()); // 간선 수
		boolean flag = true;

		// 인접 리스트 생성 및 초기화
		ArrayList<Integer>[] edge = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++)
			edge[i] = new ArrayList<Integer>();

		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edge[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		// 팬클럽 서있는 곳
		int S = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		HashSet<Integer> fans = new HashSet<Integer>();
		for (int i = 0; i < S; i++)
			fans.add(Integer.parseInt(st.nextToken()));

		List<Integer> endPoint = new ArrayList<>();

		// bfs
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (fans.contains(cur))
				continue;

			for (int i = 0; i < edge[cur].size(); i++) {
				int next = edge[cur].get(i);
				if (fans.contains(next))
					continue;

				if (edge[next].size() == 0)
					endPoint.add(next);
				else
					q.add(next);
			}
		}

		if (!endPoint.isEmpty())
			System.out.print("yes");
		else
			System.out.print("Yes");
		br.close();
	}
}