package BaekJoon.no9095_123더하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> dp = new ArrayList<>();
		dp.add(1);
		dp.add(2);
		dp.add(4);

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; ++i) {
			int x = Integer.parseInt(br.readLine());

			if (x > dp.size())
				add(x, dp);
			sb.append(dp.get(x - 1) + "\n");
		}

		System.out.print(sb);
		br.close();
	}

	private static void add(int x, ArrayList<Integer> dp) {
		int cur = dp.size();
		while (x != cur) {
			dp.add(dp.get(cur - 1) + dp.get(cur - 2) + dp.get(cur - 3));
			++cur;
		}
	}
}
