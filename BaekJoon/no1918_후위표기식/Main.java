package BaekJoon.no1918_후위표기식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Map<Character, Integer> symbol = new HashMap<Character, Integer>();
		symbol.put('(', -1);
		symbol.put(')', -1);
		symbol.put('+', 0);
		symbol.put('-', 0);
		symbol.put('*', 1);
		symbol.put('/', 1);

		String str = br.readLine();
		Stack<Character> s = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);

			// 값
			if (!symbol.containsKey(temp))
				sb.append(temp);

			// + - * / ( )
			else {
				if (isBracket(temp)) { // 괄호 검사
					if (temp == '(')
						s.add(temp);
					else {
						while (s.peek() != '(')
							sb.append(s.pop());
						s.pop(); // '(' 버림
					}
				} else {
					if (!s.isEmpty() && symbol.get(s.peek()) >= symbol.get(temp)) {
						while(!s.isEmpty() && symbol.get(s.peek()) >= symbol.get(temp))
								sb.append(s.pop());
						s.add(temp);
					} else
						s.add(temp);
				}
			}
		}

		while (!s.isEmpty())
			sb.append(s.pop());

		System.out.print(sb.toString());
		br.close();
	}

	private static boolean isBracket(char temp) {
		if (temp == '(' || temp == ')')
			return true;
		return false;
	}
}
