package BaekJoon.no14713_앵무새;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {
	static int N;
	static Stack<String>[] line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		line = new Stack[N + 2];

		for (int i = 1; i < N + 2; i++) {
			line[i] = new Stack<String>();
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens())
				line[i].push(st.nextToken());
		}

		while (!line[N + 1].isEmpty() && !lines()) {
			int temp = check();
			if (temp == 0)
				break;
			else
				line[temp].pop();
		}

		if (!line[N + 1].isEmpty() || !lines())
			System.out.print("Impossible");
		else
			System.out.print("Possible");

		br.close();
	}

	private static int check() {
		String cur = line[N + 1].pop();
		for (int i = 1; i < N + 1; i++) {
			if (!line[i].isEmpty() && line[i].peek().equals(cur))
				return i;
		}

		return 0;
	}

	private static boolean lines() {
		for (int i = 1; i < N + 1; i++) {
			if (!line[i].isEmpty())
				return false;
		}

		return true;
	}
}
