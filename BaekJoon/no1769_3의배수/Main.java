package BaekJoon.no1769_3의배수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String N = br.readLine();
		int cnt = 0; // 실행 횟수

		while (N.length() > 1) {
			N = getNext(N);
			cnt++;
		}

		System.out.println(cnt);
		if (Integer.parseInt(N) % 3 == 0)
			System.out.print("YES");
		else
			System.out.print("NO");

		br.close();
	}

	private static String getNext(String s) {
		long temp = 0;
		for (int i = 0; i < s.length(); i++)
			temp += (s.charAt(i) - '0');

		return Long.toString(temp);
	}
}
