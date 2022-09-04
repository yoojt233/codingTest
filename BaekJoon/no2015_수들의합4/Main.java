package BaekJoon.no2015_수들의합4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken()); // 목표

		st = new StringTokenizer(br.readLine());
		int[] sum = new int[N + 1]; // 누적 합 저장
		for (int i = 1; i <= N; i++)
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

		// 누적 합, 등장 횟수
		HashMap<Integer, Long> possible = new HashMap<>();

		long ans = 0;
		for (int i = 1; i <= N; i++) {
			if (sum[i] == target) // 누적 합이 목표
				++ans;

			// 누적 합에서 목표를 뺀 값이 존재한다면 그 만큼의 등장 횟수 빼면 가능하다는 뜻
			if (possible.containsKey(sum[i] - target))
				ans += possible.get(sum[i] - target);

			if (possible.containsKey(sum[i]))
				possible.put(sum[i], possible.get(sum[i]) + 1);
			else
				possible.put(sum[i], (long) 1);
		}

		System.out.print(ans);
		br.close();
	}
}
