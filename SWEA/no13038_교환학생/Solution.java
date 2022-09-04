package SWEA.no13038_교환학생;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int target = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] lesson = new int[7];
			for (int i = 0; i < 7; i++)
				lesson[i] = Integer.parseInt(st.nextToken());

			int answer = Integer.MAX_VALUE;
			for (int start = 0; start < 7; start++) {
				int day = start;
				int cnt = 0;
				if (lesson[start] == 1) {
					while (cnt < target) {
						if (lesson[day++ % 7] == 1)
							cnt++;
					}
					answer = Math.min(answer, day - start);
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
