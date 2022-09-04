package BaekJoon.no14405_피카츄;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		if (str.matches("(pi|ka|chu)*"))
			System.out.print("NO");
		else
			System.out.print("YES");
		br.close();
	}
}
