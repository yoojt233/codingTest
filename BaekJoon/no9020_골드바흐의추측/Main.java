package BaekJoon.no9020_골드바흐의추측;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			int n = sc.nextInt();
			boolean[] p = Eratos(n);

			int ans = 0;
			for (int i = n - 1; i >= n / 2; i--) {
				if (p[i] == true && p[n - i] == true)
					ans = n - i;
			}
			sb.append(ans).append(" ").append(n - ans).append("\n");
		}
		System.out.print(sb.toString());
		sc.close();
	}

	static boolean[] Eratos(int n) {
		boolean[] prime_number = new boolean[n];
		Arrays.fill(prime_number, true); // 배열의 초기화는 false로 생성된다.

		// 0과 1은 소수x
		prime_number[0] = false;
		prime_number[1] = false;

		for (int i = 2; i * i < n; i++) {
			for (int j = i; j < n; j += i) {
				prime_number[j] = false;
			}
		}

		return prime_number;
	}
}