package BaekJoon.no6603_로또;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static String[] s, result;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String str = br.readLine();
		while (!str.equals("0")) { // 마지막 줄 0이 나오면 종료
			StringTokenizer st = new StringTokenizer(str);
			k = Integer.parseInt(st.nextToken());

			s = new String[k];
			result = new String[6];

			for (int i = 0; i < k; i++)
				s[i] = st.nextToken();

			Combination(0, 0);
			sb.append("\n");
			str = br.readLine();
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static void Combination(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < result.length; i++)
				sb.append(result[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = start; i < k; i++) {
			result[cnt] = s[i];
			Combination(cnt + 1, i + 1);
		}
	}
}
