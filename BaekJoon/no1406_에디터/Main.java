package BaekJoon.no1406_에디터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		String input = br.readLine();
		for (int i = 0; i < input.length(); i++)
			left.push(input.charAt(i));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("L")) {
				if (!left.isEmpty()) {
					right.push(left.pop());
				}
			} else if (s.equals("D")) {
				if (!right.isEmpty())
					left.push(right.pop());
			} else if (s.equals("B")) {
				if (!left.isEmpty())
					left.pop();
			} else {
				left.push(st.nextToken().charAt(0));
			}
		}
		for (Character c : left)
			sb.append(c);
		while (!right.isEmpty())
			sb.append(right.pop());

		System.out.print(sb.toString());
		br.close();
	}
}
