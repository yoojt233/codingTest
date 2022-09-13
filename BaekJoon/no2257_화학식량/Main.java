package BaekJoon.no2257_화학식량;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력값: 화학식
		String formula = br.readLine();
		int ans = 0;

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < formula.length(); ++i) {
			char c = formula.charAt(i);

			if (c == '(') {
				stack.push(-1);
			} else if (c == ')') {
				int temp = 0;

				// 열린 괄호까지 더한 값을 Stack에 다시 저장
				while (stack.peek() != -1)
					temp += stack.pop();
				stack.pop(); // 열린 괄호 제거
				stack.push(temp);
			} else if (c - '0' >= 2 && c - '0' <= 9) {
				stack.push(stack.pop() * (c - '0')); // 최근 값 * 숫자
			} else {
				stack.push(atom(c));
			}
		}

		for (int i : stack)
			ans += i;

		System.out.print(ans);
		br.close();
	}

	// 원자 질량
	private static int atom(char c) {
		if (c == 'H')
			return 1;
		else if (c == 'C')
			return 12;
		else
			return 16;
	}
}
