package BaekJoon.no9935_문자열폭발;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String bomb = br.readLine();
		char trigger = bomb.charAt(bomb.length() - 1);

		String s = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			s += c;
			if (s.length() >= bomb.length() && c == trigger) {
				String temp = s.substring(s.length() - bomb.length());
				if (temp.equals(bomb))
					s = s.substring(0, s.length() - bomb.length());
			}
		}

		if (s.equals(""))
			System.out.print("FRULA");
		else
			System.out.print(s);

		br.close();
	}
}
