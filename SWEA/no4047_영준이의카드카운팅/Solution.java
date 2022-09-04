package SWEA.no4047_영준이의카드카운팅;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int[][] card = new int[4][14];

			String str = br.readLine();
			for (int i = 0; i < str.length(); i += 3) {
				String st = str.substring(i, i + 3);
				String s = st.substring(1);
				switch (st.charAt(0)) {
				case 'S':
					card[0][Integer.parseInt(s)]++;
					break;
				case 'D':
					card[1][Integer.parseInt(s)]++;
					break;
				case 'H':
					card[2][Integer.parseInt(s)]++;
					break;
				case 'C':
					card[3][Integer.parseInt(s)]++;
					break;
				}
			}

			boolean flag = false;
			a: for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= 13; j++) {
					if (card[i][j] > 1) {
						flag = true;
						break a;
					} else if (card[i][j] == 1)
						card[i][0]++;
				}
			}
			if (flag)
				sb.append("ERROR");
			else {
				for (int i = 0; i < 4; i++) {
					sb.append(13 - card[i][0]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
