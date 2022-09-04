package BaekJoon.no9935_문자열폭발;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine(); // 문자열
		String bomb = br.readLine(); // 폭탄
		char trigger = bomb.charAt(bomb.length() - 1); // 기폭제

		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			s.push(str.charAt(i));

			if (s.size() >= bomb.length() && s.peek() == trigger) { // 폭탄이다!
				boolean flag = false;
				for (int j = 0; j < bomb.length(); j++) {

					// Stack 위에서 부터, bomb 뒤에서 부터 비교
					if (s.elementAt(s.size() - j - 1) != bomb.charAt(bomb.length() - j - 1)) {
						flag = false;
						break;
					} else
						flag = true;
				}

				// 끝까지 flag가 true라는 건 bomb가 존재한다는 뜻
				if (flag)
					for (int j = 0; j < bomb.length(); j++)
						s.pop();
			}
		}

		if (s.isEmpty())
			sb.append("FRULA");
		else {
			for (char c : s)
				sb.append(c);
		}

		System.out.print(sb.toString());
		br.close();
	}
}
