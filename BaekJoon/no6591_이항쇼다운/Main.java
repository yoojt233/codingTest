package BaekJoon.no6591_이항쇼다운;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		while (check(input[0], input[1])) {
			double n = Double.parseDouble(input[0]);
			double r = Double.parseDouble(input[1]);

			// r을 작은 값으로
			r = r > n - r ? n - r : r;

			long ans = 1;
			for (int i = 0; i < r; i++)
				ans *= (n - i) / (1 + i);

			System.out.println(ans);
			input = br.readLine().split(" ");
		}
		br.close();
	}

	private static boolean check(String n, String r) {
		if (Integer.parseInt(n) == 0 && Integer.parseInt(r) == 0)
			return false;
		return true;
	}
}
