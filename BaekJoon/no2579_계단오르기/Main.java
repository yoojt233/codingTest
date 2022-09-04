package BaekJoon.no2579_계단오르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] score = new int[N + 1];
		int[] point = new int[N + 1];

		// 계단 점수
		for (int i = 1; i <= N; i++)
			point[i] = Integer.parseInt(br.readLine());

		score[1] = point[1];

		if (N >= 2) {
			score[2] = point[1] + point[2];
			for (int i = 3; i <= N; i++)
				score[i] = Math.max(score[i - 2], score[i - 3] + point[i - 1]) + point[i];
		}
		System.out.print(score[N]);
		br.close();
	}
}
