package SWEA.no7465_창용마을무리의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] people;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			answer = N;

			makeSet(N);

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				union(st.nextToken(), st.nextToken());
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	static int find(int a) {
		if (a == people[a])
			return a;
		return people[a] = find(people[a]);
	}

	static void union(String a, String b) {
		int aRoot = find(Integer.parseInt(a));
		int bRoot = find(Integer.parseInt(b));
		if (aRoot != bRoot) {
			answer -= 1; // 하나씩 합쳐질 때마다 그룹 수 -1
			people[bRoot] = aRoot;
		}
	}

	static void makeSet(int n) {
		people = new int[n + 1];
		for (int i = 1; i <= n; i++)
			people[i] = i;
	}
}
