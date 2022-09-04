package BaekJoon.no2812_크게만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		String str = br.readLine();

		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < N; i++) {
			while (!s.isEmpty() && K != 0 && s.peek() < str.charAt(i)) {
				s.pop();
				K--;
			}
			s.push(str.charAt(i));
		}

		// K가 남아있으면 뒤에서부터 빼기
		if (K > 0) {
			for (int i = 0; i < K; i++)
				s.pop();
		}

		for (char c : s)
			sb.append(c);

		System.out.print(sb.toString());
		br.close();
	}
}
