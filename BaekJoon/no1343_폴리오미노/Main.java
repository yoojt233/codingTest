package BaekJoon.no1343_폴리오미노;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] arr = { "AAAA", "BB" };

		boolean flag = true;
		StringTokenizer st = new StringTokenizer(br.readLine(), "\\.", true);
		while (st.hasMoreTokens()) {
			String cur = st.nextToken();
			if (cur.equals(".")) {
				sb.append(cur);
				continue;
			}

			int len = cur.length();
			if (len % 2 != 0) {
				flag = false;
				break;
			}

			while (len > 0) {
				if (len >= 4) {
					sb.append(arr[0]);
					len -= 4;
				} else {
					sb.append(arr[1]);
					len -= 2;
				}
			}
		}

		if (flag)
			System.out.print(sb);
		else
			System.out.print(-1);
		br.close();
	}
}
