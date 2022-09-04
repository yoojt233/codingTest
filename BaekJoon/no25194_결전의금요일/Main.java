package BaekJoon.no25194_결전의금요일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer> work;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		work = new ArrayList<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken()) % 7;
			if (temp != 0)
				work.add(temp);
		}

		if (!work.isEmpty()) {
			Collections.sort(work);
			union(0, 0);
		}

		System.out.print("NO");
		br.close();
	}

	private static void union(int idx, int sum) {
		if (sum % 7 == 4) {
			System.out.print("YES");
			System.exit(0);
		}

		if (idx >= work.size())
			return;

		union(idx + 1, sum + work.get(idx));
		union(idx + 1, sum);
	}
}
