package BaekJoon.no17352_여러분의다리가되어드리겠습니다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		// parents 초기화
		parents = new int[N];
		for (int i = 0; i < N; ++i)
			parents[i] = i;

		String str;
		while ((str = br.readLine()) != null && !str.equals("")) {
			st = new StringTokenizer(str);

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			union(a, b);
		}

		int std = find(0); // 0번 노드의 그룹이 기준
		int dif = 0;
		for (int i = 1; i < N; ++i) {
			if (find(i) != std) {
				dif = i;
				break;
			}
		}

		System.out.printf("%d %d", 1, dif + 1);
		br.close();
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		// b를 a의 그룹에 합류
		if (aRoot != bRoot)
			parents[bRoot] = aRoot;
	}

	// root 찾기
	private static int find(int n) {
		if (parents[n] == n)
			return n;

		// parents[n]을 바로 갱신
		parents[n] = find(parents[n]);
		return parents[n];
	}
}
