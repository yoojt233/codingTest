package BaekJoon.no1436_영화감독숌;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long day = 666;
		int cnt = 1;
		while (N != cnt) {
			day++;
			if (String.valueOf(day).contains("666"))
				cnt++;
		}

		System.out.print(day);
		br.close();
	}
}
