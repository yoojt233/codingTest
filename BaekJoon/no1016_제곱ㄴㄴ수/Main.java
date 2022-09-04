package BaekJoon.no1016_제곱ㄴㄴ수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long min = Long.parseLong(st.nextToken()); // 시작 숫자
		long max = Long.parseLong(st.nextToken()); // 끝 숫자

		// 시작 숫자 ~ 끝 숫자 까지의 제곱 수를 나타낼 배열
		boolean[] num = new boolean[(int) (max - min + 1)];
		int ans = 0;

		// 2의 제곱 수부터, 최대 제곱 수는 root(max).
		for (long i = 2; i <= Math.sqrt(max); i++) {
			long x = i * i;

			long op = min % x == 0 ? min / x : min / x + 1; // 제곱 수 x의 곱셈 시작값
			long ed = max / x; // 제곱 수 x의 곱셈 끝 값

			for (long j = op; j <= ed; j++)
				num[(int) (x * j - min)] = true;
		}

		// 제곱 수가 아니라면 카운트
		for (boolean b : num) {
			if (!b)
				++ans;
		}

		System.out.print(ans);
		br.close();
	}
}
