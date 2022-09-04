package BaekJoon.no10988_팰린드롬인지확인하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder before = new StringBuilder(br.readLine());
		StringBuilder after = new StringBuilder(before.reverse());
		before.reverse();
		
		if (before.toString().equals(after.toString()))
			System.out.print(1);
		else
			System.out.print(0);

		br.close();
	}
}
