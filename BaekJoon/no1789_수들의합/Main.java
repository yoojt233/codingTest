package BaekJoon.no1789_수들의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long X = Long.parseLong(br.readLine());

		int idx = 1;
		int cnt = 0;
		while (X > 0) {

			// X - idx > idx
			if (X > 2 * idx || X >= idx)
				cnt++;
			X -= idx++;
		}
		System.out.print(cnt);
		br.close();
	}
}
