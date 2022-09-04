package BaekJoon.no15486_퇴사2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		meeting[] work = new meeting[N + 1];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			work[i] = new meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i <= N; i++) {
			int end = i + work[i].time;
			if (end <= N)
				dp[end] = Math.max(dp[i - 1] + work[i].pay, dp[end]);

			if (dp[i - 1] > dp[i])
				dp[i] = dp[i - 1];
		}

		System.out.print(dp[N]);
		br.close();
	}
}

class meeting {
	int time, pay;

	public meeting(int time, int pay) {
		super();
		this.time = time - 1;
		this.pay = pay;
	}
}