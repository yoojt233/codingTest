package BaekJoon.no14267_회사문화1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] node;
	static int[] like;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 직원 수
		int M = Integer.parseInt(st.nextToken()); // 칭찬 수
		int root = 0;

		// List 배열 초기화
		node = new List[N + 1];
		for (int i = 0; i < N + 1; i++)
			node[i] = new ArrayList<Integer>();

		// 각 노드에 자식 노드를 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			int temp = Integer.parseInt(st.nextToken());

			// 루트 판단
			if (temp != -1)
				node[temp].add(i);
			else
				root = i;
		}

		// 사원 별 칭찬
		like = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			like[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
		}

		// bfs();
		dfs(root);

		for (int i = 1; i < N + 1; i++)
			sb.append(like[i] + " ");

		System.out.println(sb.toString());
		br.close();
	}

	// private static void bfs() {
	// Queue<Integer> q = new LinkedList<Integer>();
	// q.add(root);
	//
	// while (!q.isEmpty()) {
	// int cur = q.poll();
	// for (int i = 0; i < node[cur].size(); i++) {
	// int next = node[cur].get(i);
	// like[next] += like[cur];
	// q.add(next);
	// }
	// }
	// }

	private static void dfs(int cur) {
		for (int i = 0; i < node[cur].size(); i++) {
			int next = node[cur].get(i);
			like[next] += like[cur];
			dfs(next);
		}
	}
}
