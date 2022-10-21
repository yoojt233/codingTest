package BaekJoon.no1874_스택수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int idx = 0;
		int target = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i <= N; ++i) {
			stack.push(i);
			sb.append("+\n");

			while (!stack.isEmpty() && target == stack.peek()) {
				stack.pop();
				sb.append("-\n");
				++idx;

				if (idx < N) 
					target = Integer.parseInt(br.readLine());
			}
		}

		if (stack.isEmpty())
			System.out.print(sb);
		else
			System.out.print("NO");
		br.close();
	}
}
