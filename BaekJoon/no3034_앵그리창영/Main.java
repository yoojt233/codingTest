package BaekJoon.no3034_앵그리창영;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		double std = Math.sqrt(W * W + H * H);
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			sb.append(temp > std ? "NE\n" : "DA\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}
