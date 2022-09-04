package BaekJoon.no3985_롤케이크;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max = sc.nextInt(); // 빵 갯수
		int[] Bread = new int[max];

		int n = sc.nextInt(); // 사람 수
		int[] getBread = new int[n + 1];

		int[] expect = new int[n + 1]; // 예상

		for (int i = 1; i < n + 1; i++) {
			int home = sc.nextInt();
			int end = sc.nextInt();
			expect[i] = end + 1 - home;

			// 빵 번호칠하기
			for (int j = home - 1; j < end; j++) {
				if (Bread[j] == 0)
					Bread[j] = i;
				else
					continue;
			}
		}

		for (int i = 0; i < max; i++) {
			getBread[Bread[i]]++;
		}
		getBread[0] = 0;

		int expt = 0;
		int winner = 0;
		for (int i = 1; i < n + 1; i++) {
			if (expect[i] > expect[expt])
				expt = i;
			if (getBread[i] > getBread[winner])
				winner = i;
		}
		System.out.println(expt);
		System.out.println(winner);
		sc.close();
	}
}
