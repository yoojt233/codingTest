package BaekJoon.no1735_분수합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] fraction = new int[2][2];
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			fraction[i][0] = Integer.parseInt(st.nextToken());
			fraction[i][1] = Integer.parseInt(st.nextToken());
		}

		int a = (fraction[0][0] * fraction[1][1]) + (fraction[1][0] * fraction[0][1]);
		int b = fraction[0][1] * fraction[1][1];

		int gcd = getGcd(a, b);
		System.out.printf("%d %d", a / gcd, b / gcd);

		br.close();
	}

	private static int getGcd(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}

		int cd = b;
		if (a % b != 0)
			cd = getGcd(b, a % b);

		return cd;
	}
}
