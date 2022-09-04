package SWEA.no8458_원점으로집합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			int ans = 0;
			boolean[] even = new boolean[N]; // 짝수냐 홀수냐

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Math.abs(Integer.parseInt(st.nextToken()));
				int y = Math.abs(Integer.parseInt(st.nextToken()));

				// 짝수
				if ((x + y) % 2 == 0)
					even[i] = true;

				max = Integer.max(max, x + y);
			}

			boolean flag = even[0];

			// 하나라도 서로 짝수, 홀수가 다르면 불가능
			for (boolean b : even) {
				if (flag != b) {
					ans = -1;
					break;
				}
			}

			if (ans != -1)
				ans = getAns(flag);

			sb.append("#" + t + " " + ans + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static int getAns(boolean flag) {
		int idx = 0, sum = 0;

		while (true) {
			sum += idx;

			if (max <= sum) {

				// x + y 들이 짝수이고, sum 값이 짝수
				if (flag && sum % 2 == 0)
					return idx;

				// x + y 들이 홀수이고, sum 값이 홀수
				if (!flag && sum % 2 == 1)
					return idx;
			}

			idx++;
		}
	}
}
