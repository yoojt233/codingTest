package BaekJoon.no14709_여우사인;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static boolean flag = true;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		HashSet<Integer>[] finger = new HashSet[6];
		for (int i = 1; i < 6; ++i)
			finger[i] = new HashSet<>();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			finger[a].add(b);
			finger[b].add(a);
		}

		for (int i = 1; i < 6; ++i) {
			if (!flag)
				break;

			if (i == 1 || i == 3 || i == 4)
				flag = check(finger[i], i);
			else {
				if (finger[i].size() != 0)
					flag = false;
			}
		}

		System.out.print(flag ? "Wa-pa-pa-pa-pa-pa-pow!" : "Woof-meow-tweet-squeek");
		br.close();
	}

	private static boolean check(HashSet<Integer> set, int i) {
		if (set.size() != 2)
			return false;

		switch (i) {
		case 1:
			if (!set.contains(3) || !set.contains(4))
				return false;
			break;
		case 3:
			if (!set.contains(1) || !set.contains(4))
				return false;
			break;
		case 4:
			if (!set.contains(1) || !set.contains(3))
				return false;
			break;
		}

		return true;
	}
}
