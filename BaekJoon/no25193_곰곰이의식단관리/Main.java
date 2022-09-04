package BaekJoon.no25193_곰곰이의식단관리;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// string 사이즈
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int others = 0;
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) != 'C')
				others++;
		}

		System.out.print(N / (others + 1));
		br.close();
	}
}
