package BaekJoon.no3040_백설공주와일곱난쟁이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static String[] WhoIsDwarf = new String[9];
	static String[] SevenDwarf = new String[7];
	static int sum = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			WhoIsDwarf[i] = str;
		}
		realDwarf(0, 0);
		br.close();
		bw.close();
	}

	private static void realDwarf(int cnt, int x) {
		if (sum > 100)
			return;
		if (cnt == 7) {
			if (sum < 100)
				return;
			for (int i = 0; i < 7; i++)
				sb.append(SevenDwarf[i]).append("\n");
			System.out.println(sb.toString());
			return;
		}
		for (int i = x; i < 9; i++) {
			SevenDwarf[cnt] = WhoIsDwarf[i];
			sum += Integer.parseInt(WhoIsDwarf[i]);
			realDwarf(cnt + 1, i + 1);
			sum -= Integer.parseInt(WhoIsDwarf[i]);
		}
	}
}