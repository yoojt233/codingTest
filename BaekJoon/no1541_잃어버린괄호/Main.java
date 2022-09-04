package BaekJoon.no1541_잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// -를 기준으로 짜르기
		String input[] = br.readLine().split("\\-");
		int answer = 0;

		for (int i = 0; i < input.length; i++) {
			int sum = 0;
			String sub[] = input[i].split("\\+");

			// +로 구분한 후 sum에 더하기
			for (int j = 0; j < sub.length; j++)
				sum += Integer.parseInt(sub[j]);

			// 첫 숫자일 경우 더하기 아닐경우 전부 빼기
			if (i == 0)
				answer += sum;
			else
				answer -= sum;
		}
		System.out.print(answer);
		br.close();
	}
}
