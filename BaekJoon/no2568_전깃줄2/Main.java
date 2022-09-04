package BaekJoon.no2568_전깃줄2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		line[] lines = new line[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lines[i] = new line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(lines);

		save[] idx = new save[N];

		int len = 0;
		int[] dp = new int[N];
		dp[0] = lines[0].to;
		idx[0] = new save(0, lines[0].from);

		for (int i = 1; i < N; i++) {
			line cur = lines[i];
			if (dp[len] < cur.to) {
				dp[++len] = cur.to;
				idx[i] = new save(len, cur.from);
			} else {
				int where = Arrays.binarySearch(dp, 0, len + 1, cur.to);
				idx[i] = new save(-where - 1, cur.from);
				if (dp[-where - 1] > cur.to)
					dp[-where - 1] = cur.to;
			}
		}

		sb.append(N - len - 1 + "\n");

		int[] elec = new int[len + 1];
		for (int i = N - 1; i >= 0; i--) {
			if (idx[i].where == len)
				elec[len--] = idx[i].from;

			if (len < 0)
				break;
		}

		for (int i = 0; i < N; i++) {
			if (Arrays.binarySearch(elec, lines[i].from) < 0)
				sb.append(lines[i].from + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}

class save {
	int where, from;

	public save(int where, int from) {
		super();
		this.where = where;
		this.from = from;
	}
}

class line implements Comparable<line> {
	int from, to;

	public line(int from, int to) {
		super();
		this.from = from;
		this.to = to;
	}

	@Override
	public int compareTo(line o) {
		return this.from - o.from;
	}
}