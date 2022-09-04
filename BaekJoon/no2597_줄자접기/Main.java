package BaekJoon.no2597_줄자접기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double[][] point;
	static double start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		double N = Integer.parseInt(br.readLine());

		point = new double[3][2];
		start = 0;

		// [0] : 빨강 [1] : 파랑 [2] : 노랑
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Double.parseDouble(st.nextToken());
			point[i][1] = Double.parseDouble(st.nextToken());
		}

		for (int i = 0; i < 3; i++) {
			if (point[i][0] != point[i][1])
				N = fold(i, N);
		}
		System.out.printf("%.1f", N);
		br.close();
	}

	private static double fold(int cnt, double n) {
		double stand = point[cnt][0] + point[cnt][1];
		double left = Math.abs((stand / 2) - start);
		double right = Math.abs(n - left);

		start = stand / 2;
		for (int i = cnt + 1; i < 3; i++) {
			point[i][0] = start + Math.abs(start - point[i][0]);
			point[i][1] = start + Math.abs(start - point[i][1]);
		}
		return Math.max(left, right);
	}
}
