package BaekJoon.no2671_잠수함식별;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		if (s.matches("(100+1+|01)+"))
			System.out.print("SUBMARINE");
		else
			System.out.print("NOISE");

		br.close();
	}
}
