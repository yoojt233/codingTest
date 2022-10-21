package BaekJoon.no1929_소수구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] std = br.readLine().split(" ");
		boolean[] pn = new boolean[Integer.parseInt(std[1]) + 1];
		pn[1] = true;
		for (int i = 2; i < Math.sqrt(Integer.parseInt(std[1]) + 1); ++i) {
			if (pn[i])
				continue;
			int x = 2;
			while (i * x < pn.length)
				pn[i * x++] = true;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = Integer.parseInt(std[0]); i < pn.length; ++i) {
			if (!pn[i])
				sb.append(i + "\n");
		}

		System.out.print(sb);
		br.close();
	}
}