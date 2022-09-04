package BaekJoon.no2309_일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] WhoIsDwarf;
	static int[] SevenDwarf;
	static int[] printDwarf;
	static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		WhoIsDwarf = new int[9];
		SevenDwarf = new int[7];
		printDwarf = new int[7];
		sum = 0;

		for (int i = 0; i < 9; i++)
			WhoIsDwarf[i] = Integer.parseInt(br.readLine());

		realDwarf(0, 0);
		Arrays.sort(printDwarf);
		for (int i = 0; i < 7; i++)
			sb.append(printDwarf[i]).append("\n");

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
		br.close();
	}

	private static void realDwarf(int cnt, int x) {
		if (sum > 100)
			return;
		if (cnt == 7) {
			if (sum != 100)
				return;
			printDwarf = SevenDwarf.clone();
			return;
		}
		for (int i = x; i < 9; i++) {
			SevenDwarf[cnt] = WhoIsDwarf[i];
			sum += WhoIsDwarf[i];
			realDwarf(cnt + 1, i + 1);
			sum -= WhoIsDwarf[i];
		}
	}
}