package BaekJoon.no7490_0만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			N = Integer.parseInt(br.readLine());

			isZero(0, 2, "1");
			sb.append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	// 횟수, 현재 숫자, 수식
	private static void isZero(int cnt, int num, String string) {
		if (cnt == N - 1) {
			int total = 0;
			String temp = "";

			// +? -? // 초기값은 무조건 더해야하므로 true로 시작.
			boolean plus = true;

			for (int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);

				// 공백은 건너 뛴다.
				if (c == ' ')
					continue;

				// 숫자
				if ('1' <= c && c <= '9')
					temp += c;
				else { // 연산자 확인
					total = plus ? total + Integer.parseInt(temp) : total - Integer.parseInt(temp);
					plus = c == '+' ? true : false;
					temp = ""; // 초기화
				}
			}

			// 마지막 temp 계산
			total = plus ? total + Integer.parseInt(temp) : total - Integer.parseInt(temp);

			if (total == 0)
				sb.append(string + "\n");

			return;
		}

		isZero(cnt + 1, num + 1, string + " " + num);
		isZero(cnt + 1, num + 1, string + "+" + num);
		isZero(cnt + 1, num + 1, string + "-" + num);
	}
}
