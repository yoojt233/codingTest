package BaekJoon.no2407_조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");

		int[] input = new int[in.length];
		for (int i = 0; i < in.length; ++i)
			input[i] = Integer.parseInt(in[i]);

		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;

		int size = input[1];
		for (int i = 0; i < size; ++i) {
			a = a.multiply(BigInteger.valueOf(input[0]--));
			b = b.multiply(BigInteger.valueOf(input[1]--));
		}

		System.out.print(a.divide(b));
		br.close();
	}
}
