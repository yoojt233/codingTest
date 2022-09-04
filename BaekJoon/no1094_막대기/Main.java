package BaekJoon.no1094_막대기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		Stack<Integer> stick = new Stack<Integer>();
		stick.push(64);
		while (sum(stick) > X) {
			int least = stick.pop();
			stick.push(least / 2);
			if (sum(stick) < X)
				stick.push(least / 2);
		}
		System.out.print(stick.size());
		br.close();
	}

	private static int sum(Stack<Integer> stick) {
		int sum = 0;
		for (Integer i : stick)
			sum += i;
		return sum;
	}
}
