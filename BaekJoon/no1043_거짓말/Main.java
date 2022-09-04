package BaekJoon.no1043_거짓말;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 파티 수

		makeSet();
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());

		// 이미 진실을 아는 사람들
		List<Integer> know = new ArrayList<>();
		for (int i = 0; i < x; i++) {
			int temp = Integer.parseInt(st.nextToken());
			know.add(temp);
			parents[temp] = 0;
		}

		int cnt = 0;

		// 아는 사람이 없다면 모든 파티에서 가능
		if (know.isEmpty())
			cnt = M;
		else {

			// 파티 초기화
			List<Integer>[] party = new List[M];
			for (int i = 0; i < M; i++)
				party[i] = new ArrayList<>();

			// 파티 멤버 입력
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());

				while (st.hasMoreTokens())
					party[i].add(Integer.parseInt(st.nextToken()));

				for (int j = 0; j < party[i].size() - 1; j++)
					union(party[i].get(j), party[i].get(j + 1));
			}

			int std = find(know.get(0)); // 아는 사람들의 루트 값
			for (int i = 0; i < M; i++) {

				// 파티에 진실을 아는 사람이 없다면
				if (!truth(std, party[i]))
					cnt++;
			}
		}

		System.out.print(cnt);
		br.close();
	}

	private static boolean truth(int std, List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (find(list.get(i)) != std)
				return false;
		}
		return true;
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot)
			parents[bRoot] = aRoot;
	}

	private static int find(int num) {
		if (parents[num] == num)
			return num;
		else
			return parents[num] = find(parents[num]);
	}

	private static void makeSet() {
		parents = new int[N + 1];
		for (int i = 0; i < N + 1; i++)
			parents[i] = i;
	}
}
