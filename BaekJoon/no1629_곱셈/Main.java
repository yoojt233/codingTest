package BaekJoon.no1629_곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken()); // 어떤 수를?
		long b = Long.parseLong(st.nextToken()); // 몇 제곱?
		long c = Long.parseLong(st.nextToken()); // 뭘로 나눈 나머지?

		System.out.println(div(a, b, c) % c);
		br.close();
	}

	private static long div(long a, long b, long c) {
		if (b == 0) // 0승은 1
			return 1;
		else if (b == 1) // 1승
			return a;
		else if (b % 2 == 0) { // 짝수면 그대로 b/2
			long x = div(a, b / 2, c) % c;
			return (x * x) % c;
		} else { // 홀수면 a를 한번 더 곱한다
			long x = div(a, b / 2, c) % c;
			return (((x * x) % c) * a) % c;
		}
	}
}
