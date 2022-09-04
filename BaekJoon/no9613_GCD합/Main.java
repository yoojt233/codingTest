package BaekJoon.no9613_GCD합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] number;
	static int N;
	static long sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			number = new int[N];
			sum = 0;

			for (int i = 0; i < N; i++)
				number[i] = Integer.parseInt(st.nextToken());

			combo(0, 0, new int[2]);
			sb.append(sum + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void combo(int cnt, int start, int[] sel) {
		if (cnt == 2) {
			sum += gcd(sel[0], sel[1]);
			return;
		}

		for (int i = start; i < N; i++) {
			sel[cnt] = number[i];
			combo(cnt + 1, i + 1, sel);
		}

	}

	private static int gcd(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}

		int cd = b;
		if (a % b != 0)
			cd = gcd(b, a % b);

		return cd;
	}
}
