package SWEA.no1940_가랏RC카;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int answer, speed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int N = Integer.parseInt(br.readLine());
			answer = 0;
			speed = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				switch (st.nextToken()) {
				case "1":
					speed += Integer.parseInt(st.nextToken());
					break;
				case "2":
					speed -= Integer.parseInt(st.nextToken());
					if (speed < 0)
						speed = 0;
					break;
				}
				answer += speed;
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
