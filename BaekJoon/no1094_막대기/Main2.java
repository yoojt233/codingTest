package BaekJoon.no1094_막대기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine()); // 목표 길이
		int ans = 0; // 막대 갯수

		while (X != 0) {
			int stick = 1;
			while (stick <= X) // 목표 길이보다 커질 때 까지 2배씩
				stick *= 2;
			ans++;

			// while문에서 *2 해서 나오니 /2 필요
			X -= stick / 2;
		}

		System.out.print(ans);
		br.close();
	}
}
