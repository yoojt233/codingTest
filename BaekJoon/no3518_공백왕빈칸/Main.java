package BaekJoon.no3518_공백왕빈칸;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		ArrayList<Integer> cnt = new ArrayList<>();
		StringTokenizer st;

		String s;
		while ((s = br.readLine()) != null && !s.isEmpty()) {
			ArrayList<String> str = new ArrayList<>();
			st = new StringTokenizer(s);

			int idx = 0;
			while (st.hasMoreTokens()) {
				String temp = st.nextToken();
				int len = temp.length();

				try {
					cnt.set(idx, Math.max(cnt.get(idx), len));
				} catch (Exception e) {
					cnt.add(len);
				} finally {
					++idx;
				}

				str.add(temp);
			}

			list.add(str);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); ++i) {
			ArrayList<String> cur = list.get(i);
			for (int j = 0; j < cur.size(); ++j) {
				sb.append(cur.get(j));
				if (j == cur.size() - 1)
					continue;
				for (int k = 0; k < cnt.get(j) - cur.get(j).length() + 1; ++k)
					sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}
}
