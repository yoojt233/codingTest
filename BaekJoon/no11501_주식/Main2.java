package BaekJoon.no11501_주식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] pr = new int[N];
			int[] max = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pr[i] = Integer.parseInt(st.nextToken());
				max[i] = i;
			}

			for (int i = 0; i < N; i++) {
				int where = getMax(pr, i);
				for (int j = i; j < where; j++)
					max[j] = where;
				i = where;
			}

			long ans = 0;
			for (int i = 0; i < N; i++)
				ans += (pr[max[i]] - pr[i]);

			sb.append(ans + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static int getMax(int[] pr, int op) {
		int temp = op;
		for (int i = op + 1; i < pr.length; i++) {
			if (pr[temp] < pr[i])
				temp = i;
		}

		return temp;
	}
}
