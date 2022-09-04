package BaekJoon.no2986_파스칼;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if (N > 1) {
			int cnt = N / 2;
			if (N % 2 == 0) {
				System.out.print(cnt);
			} else {
				int i = N / 2;
				while (N % i != 0) {
					i--;
					cnt++;
				}
				System.out.print(cnt);
			}
		} else
			System.out.print(0);
	}
}
