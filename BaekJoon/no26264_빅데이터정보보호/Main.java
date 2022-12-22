package BaekJoon.no26264_빅데이터정보보호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();

		String s = br.readLine();
		int size = s.length();

		int[] alpha = new int[26];
		for (int i = 0; i < size; ++i)
			++alpha[s.charAt(i) - 'a'];

		int temp = alpha['b' - 'a'] - alpha['s' - 'a'];
		System.out.print(temp > 0 ? "bigdata?" : temp < 0 ? "security!" : "bigdata? security!");
		br.close();
	}
}
