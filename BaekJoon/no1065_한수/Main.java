package BaekJoon.no1065_한수;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 한수의 갯수
		int cnt = 0;

		for (int a = 1; a <= n; a++) {
			if (a < 10) {
				cnt++;
			} else if (a < 100) {
				cnt++;
			} else if (a < 1000) {
				int x = a / 100;
				int y = (a % 100) / 10;
				int z = a % 10;

				// 등차 확인
				if ((x - y) == (y - z))
					cnt++;
			} else {
				break;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
