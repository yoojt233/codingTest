package BaekJoon.no1105_팔;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		int n = input[1].length() - input[0].length();
		int ans = 0;
		if (n == 0) {
			for (int i = 0; i < input[0].length(); ++i) {
				if (input[0].charAt(i) != input[1].charAt(i))
					break;
				else if (input[0].charAt(i) == '8')
					++ans;
			}
		}

		System.out.print(ans);
		br.close();
	}
}
