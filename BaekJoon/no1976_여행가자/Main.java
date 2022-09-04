package BaekJoon.no1976_여행가자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		makeSet();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (st.nextToken().equals("1")) // 1이면 연결
					union(i, j);
			}
		}

		st = new StringTokenizer(br.readLine());
		Set<Integer> group = new HashSet<Integer>();
		for (int i = 0; i < M; i++)
			group.add(findSet(Integer.parseInt(st.nextToken()) - 1));
		// group.add(parents[Integer.parseInt(st.nextToken()) - 1]); // 나중에 집합이 합쳐질 경우, 자식은 루트가 안바뀌기 때문에 틀린다.

		if (group.size() != 1)
			System.out.print("NO");
		else
			System.out.print("YES");

		br.close();
	}

	// 집합 합치기
	private static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot != bRoot)
			parents[bRoot] = aRoot;
	}

	// 루트 찾기
	private static int findSet(int x) {
		if (parents[x] == x)
			return x;
		return parents[x] = findSet(parents[x]);
	}

	// 부모 루트 저장할 배열 생성
	private static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++)
			parents[i] = i;
	}
}
