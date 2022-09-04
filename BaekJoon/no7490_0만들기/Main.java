package BaekJoon.no7490_0만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static StringBuilder sb;
	static int N;
	static char[] op = { ' ', '+', '-' };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			N = Integer.parseInt(br.readLine());

			// 연산자 순열
			permu(0, new char[N]);
			sb.append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

	private static void permu(int cnt, char[] sel) {

		// 연산자 선택 완료
		if (cnt == N - 1) {
			Stack<Character> s = new Stack<>();

			// 연산자와 숫자를 뒤에서부터 스택에 담는다.
			int num = N;
			while (num > 0) {
				s.push((char) (num-- + '0'));

				// 공백은 넣지 않는다.
				if (num > 0 && sel[num] != ' ')
					s.push(sel[num]);
			}

			int total = getNum(s); // 초기값
			while (!s.isEmpty()) {
				char c = s.pop(); // 무조건 연산자
				int temp = getNum(s);
				if (c == '+')
					total += temp;
				else
					total -= temp;
			}

			if (total == 0) {
				for (int i = 1; i < N; i++)
					sb.append(i).append(sel[i]);
				sb.append(N + "\n");
			}
			return;
		}

		// 두 숫자 사이에 들어갈 연산자 선택
		for (int i = 0; i < 3; i++) {
			sel[cnt + 1] = op[i];
			permu(cnt + 1, sel);
		}
	}

	// 두 숫자 사이가 공백인 경우 합친다.
	private static int getNum(Stack<Character> s) {
		int temp = 0;
		while (!s.isEmpty() && !isOperator(s.peek()))
			temp = temp * 10 + (s.pop() - '0');
		return temp;
	}

	// 연산자 or 숫자
	private static boolean isOperator(Character p) {
		if (p == '+' || p == '-')
			return true;
		return false;
	}
}
