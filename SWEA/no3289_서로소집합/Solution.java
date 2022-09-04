package SWEA.no3289_서로소집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 집합 원소의 갯수
			int m = Integer.parseInt(st.nextToken()); // 연산의 갯수
			makeSet(N);

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				if (st.nextToken().equals("0")) {
					union(st.nextToken(), st.nextToken());
				} else {
					check(st.nextToken(), st.nextToken());
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	// 집합 생성
	public static void makeSet(int n) {
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++)
			parents[i] = i;
	}

	public static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}

	public static void union(String A, String B) {
		int aRoot = findSet(Integer.parseInt(A));
		int bRoot = findSet(Integer.parseInt(B));
		if (aRoot != bRoot)
			parents[bRoot] = aRoot;
	}

	public static void check(String A, String B) {
		if (findSet(Integer.parseInt(A)) == findSet(Integer.parseInt(B)))
			sb.append(1);
		else
			sb.append(0);
	}
}
