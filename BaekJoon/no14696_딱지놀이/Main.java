package BaekJoon.no14696_딱지놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int t = 0; t < N; t++) {
			int[][] num = new int[2][5];

			// 딱지 정보
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				int size = Integer.parseInt(st.nextToken());
				for (int j = 0; j < size; j++) {
					int temp = Integer.parseInt(st.nextToken());
					num[i][temp]++;
				}
			}

			int i = 4;
			while (i > 0) {
				if (num[0][i] > num[1][i]) {
					sb.append("A").append("\n");
					break;
				} else if (num[0][i] < num[1][i]) {
					sb.append("B").append("\n");
					break;
				} else if (num[0][i] == num[1][i] && i > 1) {
					i--;
				} else {
					sb.append("D").append("\n");
					break;
				}
			}
		}

		System.out.print(sb.toString());
		br.close();
	}
}
