package BaekJoon.no2386_도비의영어공부;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String temp = br.readLine();
			if ("#".equals(temp))
				break;

			char std = temp.charAt(0);
			int cnt = -1;
			for (char c : temp.toLowerCase().toCharArray()) {
				if (std == c)
					++cnt;
			}
			sb.append(std + " " + cnt + "\n");
		}

		System.out.print(sb);
		br.close();
	}
}
