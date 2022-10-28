package BaekJoon.no2386_도비의영어공부;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String s;
		while (!(s = br.readLine()).equals("#")) {
			st = new StringTokenizer(s);
			char c = st.nextToken().charAt(0);

			int cnt = 0;
			while (st.hasMoreTokens()) {
				String temp = st.nextToken().toLowerCase();
				int len = temp.length();
				for (int i = 0; i < len; ++i) {
					if (temp.charAt(i) == c)
						++cnt;
				}
			}
			sb.append(c + " " + cnt + "\n");
		}

		System.out.print(sb);
		br.close();
	}
}