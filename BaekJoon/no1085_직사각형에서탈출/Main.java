package BaekJoon.no1085_직사각형에서탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] lec = br.readLine().split(" ");
		int width = Integer.min(num(lec[0]), num(lec[2]) - num(lec[0]));
		int height = Integer.min(num(lec[1]), num(lec[3]) - num(lec[1]));
		
		System.out.print(Integer.min(width, height));
		br.close();
	}

	private static int num(String s) {
		return Integer.parseInt(s);
	}
}
