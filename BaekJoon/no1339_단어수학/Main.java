package BaekJoon.no1339_단어수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] alphabet = new int[26];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				
				// 해당 알파벳 위치에 가중치 더하기
				alphabet[c - 'A'] += Math.pow(10, s.length() - j - 1);
			}
		}

		// 가중치에 따른 정렬
		Arrays.sort(alphabet);

		int total = 0;
		
		// 알파벳은 최대 10개로 주어졌다.
		int num = 9;
		
		// 맨 뒤에서 부터 큰 숫자 부여
		for (int i = 0; i < 10; i++)
			total += alphabet[25 - i] * num--;

		System.out.println(total);
		br.close();
	}
}