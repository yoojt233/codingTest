package BaekJoon.no2839_설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sugar = Integer.parseInt(br.readLine());

		int cnt = 0;
		while (true) {
			if (sugar % 5 == 0) {
				cnt += sugar / 5;
				break;
			} else if (sugar < 3) {
				cnt = -1;
				break;
			} else {
				sugar -= 3;
				cnt++;
			}
		}
		System.out.print(cnt);
	}
}
