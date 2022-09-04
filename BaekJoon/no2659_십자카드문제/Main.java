package BaekJoon.no2659_십자카드문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static Set<Integer> cn = new TreeSet<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] number = new int[4];

		for (int i = 0; i < 4; i++)
			number[i] = Integer.parseInt(st.nextToken());

		int num = makeNum(number);

		combo(0, 1, new int[4]);
		int idx = 1;
		for (int x : cn) {
			if (x == num) {
				System.out.print(idx);
				break;
			}
			idx++;
		}
		br.close();
	}

	private static int makeNum(int[] number) {
		int x = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			int temp = number[(i + 1) % 4] * 1000 + number[(i + 2) % 4] * 100 + number[(i + 3) % 4] * 10
					+ number[(i + 4) % 4];

			x = Math.min(x, temp);
		}
		return x;
	}

	private static void combo(int cnt, int start, int[] numb) {
		if (cnt == 4) {
			cn.add(makeNum(numb));
			return;
		}

		for (int i = start; i <= 9; i++) {
			numb[cnt] = i;
			combo(cnt + 1, start, numb);
		}
	}
}
