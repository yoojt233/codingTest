package BaekJoon.no24023_아기홍윤;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int sum, start, end;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input[] = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(input[i]);
			if (check(K, n, i))
				break;
		}

		if (sum == K)
			sb.append(start).append(" ").append(end);
		else
			sb.append(-1);
		System.out.println(sb.toString());
		br.close();
	}

	private static boolean check(int k, int n, int idx) {
		if ((k | n) == k) {
			sum |= n;
			if (sum == k) {
				if (!flag)
					start = idx + 1;
				end = idx + 1;
				return true;
			} else if (!flag) {
				start = idx + 1;
				flag = true;
			}
		} else {
			sum = 0;
			flag = false;
		}
		return false;
	}
}
