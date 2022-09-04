package BaekJoon.no21394_숫자카드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = 0;
			int[] num = new int[10];
			for (int i = 0; i < 9; i++) {
				int k = Integer.parseInt(st.nextToken());
				if (k > 0) {
					num[i + 1] += k;
					n += k;
				}
			}

			num[9] += num[6];
			num[6] = 0;

			int[] x = new int[n];
			for (int i = 0; i < n; i++)
				x[i] = get(num);

			int idx = 0;
			while (idx < n) {
				sb.append(x[idx] + " ");
				idx += 2;
			}

			if (n % 2 == 0) {
				--idx;
			} else {
				idx -= 3;
			}

			while (idx > 0) {
				sb.append(x[idx] + " ");
				idx -= 2;
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	private static int get(int[] num) {
		for (int i = 9; i >= 1; i--) {
			if (num[i]-- > 0) {
				return i;
			}
		}
		return 0;
	}
}
