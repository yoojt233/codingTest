package BaekJoon.no6527_빙고라니;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int end = 0;
		int words = 0;
		HashSet<String> set = new HashSet<>();

		while ((str = br.readLine().trim()) != "" && !str.isEmpty()) {
			String[] input = str.split("\\W|\\d");

			for (String cur : input) {
				String s = cur.trim().toUpperCase();
				if (s.isEmpty())
					continue;

				if ("BULLSHIT".equals(s)) {
					++end;
					words += set.size();
					set.clear();
				} else
					set.add(s);
			}
		}

		int x = gcd(words, end);
		System.out.printf("%d / %d", words / x, end / x);
		br.close();
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}
