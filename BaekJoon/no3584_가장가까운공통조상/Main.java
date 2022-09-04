package BaekJoon.no3584_가장가까운공통조상;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] nodes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			N = Integer.parseInt(br.readLine());
			nodes = new int[N + 1];

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());

				nodes[n] = p;
			}

			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> l1 = getList(Integer.parseInt(st.nextToken()));
			ArrayList<Integer> l2 = getList(Integer.parseInt(st.nextToken()));

			sb.append(getAns(l1, l2) + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static int getAns(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		for (int i : l1) {
			for (int k : l2) {
				if (i == k)
					return k;
			}
		}

		return 0;
	}

	private static ArrayList<Integer> getList(int start) {
		ArrayList<Integer> l = new ArrayList<>();

		int cur = start;
		l.add(cur);
		while (nodes[cur] != 0) {
			l.add(nodes[cur]);
			cur = nodes[cur];
		}

		return l;
	}
}