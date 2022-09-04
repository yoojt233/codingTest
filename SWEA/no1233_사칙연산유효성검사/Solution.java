package SWEA.no1233_사칙연산유효성검사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static char node[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = 10; // 테스트 케이스
		for (int t = 1; t <= tc; t++) {
			int cnt = Integer.parseInt(br.readLine()); // 노드 갯수

			int ans = 1;

			node = new char[cnt + 1]; // 배열로 저장
			for (int i = 0; i < cnt; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				st.nextToken();
				node[i + 1] = st.nextToken().charAt(0);
			}

			// 리프 노드에 연산자가 들어있는 경우
			for (int i = cnt / 2 + 1; i <= cnt; i++) {
				if (node[i] == '/' || node[i] == '*' || node[i] == '+' || node[i] == '-') {
					ans = 0;
					break;
				}
			}

			// 다른 노드에 숫자가 들어있는 경우
			for (int i = 2; i <= cnt; i++) {
				if (!((node[i / 2] - '0') < 10)) {
					ans = 0;
					break;
				}
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
}
