package BaekJoon.no1302_베스트셀러;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());

		String ans = "";
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; ++i) {
			String cur = br.readLine();
			int x = map.getOrDefault(cur, 0) + 1;
			map.put(cur, x);

			if ((x > max) || (max == x && cur.compareTo(ans) < 0)) {
				max = x;
				ans = cur;
			}
		}

		System.out.print(ans);
		br.close();
	}
}
