package BaekJoon.no2352_반도체설계;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] port = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			port[i] = Integer.parseInt(st.nextToken());

		dp[0] = port[0];
		int last = 0; // 현재 저장된 마지막 인덱스
		for (int i = 1; i < N; i++) {
			if (dp[last] < port[i])
				dp[++last] = port[i];
			else {
				int where = Arrays.binarySearch(dp, 0, last + 1, port[i]);
				if (where < 0)
					dp[-where - 1] = port[i];
			}
		}

		// 인덱스가 0부터 시작하므로 1 증가 후 출력
		System.out.print(last + 1);
		br.close();
	}
}
