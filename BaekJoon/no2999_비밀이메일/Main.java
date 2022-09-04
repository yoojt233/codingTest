package BaekJoon.no2999_비밀이메일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] divisor;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		String str = br.readLine();
		int n = str.length();

		int x = 0;
		while (x * x <= n)
			x++;

		// 약수 확인
		divisor = new boolean[x + 1];
		for (int i = 1; i <= x; i++) {
			if ((n % i) == 0)
				divisor[i] = true;
		}

		// 행 값 구하기
		int r = 0;
		for (int i = 1; i < x; i++) {
			if (divisor[i] == true) {
				r = i;
			}
		}

		for (int i = 0; i < r; i++) {
			int at = i;
			while(at < str.length()) {
				sb.append(str.charAt(at));
				at+=r;
			}
		}
		System.out.print(sb.toString());
	}
}
