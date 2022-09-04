package BaekJoon.no1789_수들의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long X = Long.parseLong(br.readLine());

		double ans = 1;

		// 1 + 2 + ... + (i-1) + i <= X < 1 + 2 + ... + i + (i+1) 이면 ans = i
		// ex) 55는 1~10까지의 합, 66은 1~11까지의 합. 따라서 55~65까지는 10개의 합으로 표현가능
		for (double i = 1; i < X; i++) {
			if (sum(i) > X) {
				ans = i - 1;
				break;
			} else if (sum(i) == X) {
				ans = i;
				break;
			}
		}
		System.out.print((int) ans);
		br.close();
	}

	private static double sum(double i) {
		return i * (i + 1) / 2;
	}
}
