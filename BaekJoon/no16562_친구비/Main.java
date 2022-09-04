package BaekJoon.no16562_친구비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] money, parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
		int k = Integer.parseInt(st.nextToken()); // 가진 돈

		money = new int[N + 1]; // 개인당 친구비
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++)
			money[i] = Integer.parseInt(st.nextToken());

		makeSet();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		// 각 집합의 루트들을 저장
		Set<Integer> roots = new HashSet<>();
		for (int i = 1; i < N + 1; i++) {
			int root = find(i);
			if (!roots.contains(root))
				roots.add(root);
		}

		// 루트들의 친구비 합
		int total = 0;
		for(int i : roots)
			total += money[i];

		if (total <= k)
			System.out.print(total);
		else
			System.out.print("Oh no");

		br.close();
	}

	private static void makeSet() {
		parents = new int[N + 1];
		for (int i = 0; i < N + 1; i++)
			parents[i] = i;
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (money[aRoot] < money[bRoot])
			parents[bRoot] = aRoot;
		else
			parents[aRoot] = bRoot;
	}

	private static int find(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}
}
