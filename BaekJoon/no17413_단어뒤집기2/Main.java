package BaekJoon.no17413_단어뒤집기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		Stack<Character> temp = new Stack<>();

		// 입력 문자열
		char[] s = br.readLine().toCharArray();

		for (int i = 0; i < s.length; i++) {
			// <를 만나면 stack을 출력한 후, >일 때까지 출력
			if (s[i] == '<') {
				pStack(temp);
				while (s[i] != '>')
					sb.append(s[i++]);
				sb.append('>');
			} else if (s[i] == ' ') { // blank를 만나면 stack 출력 후, blank 출력
				pStack(temp);
				sb.append(s[i]);
			} else // < > blank 가 아닐 경우, stack에 push
				temp.push(s[i]);
		}
		// 마지막 남아있는 stack 출력
		pStack(temp);

		System.out.print(sb.toString());
		br.close();
	}

	private static void pStack(Stack<Character> temp) {
		while (!temp.isEmpty())
			sb.append(temp.pop());
	}
}
