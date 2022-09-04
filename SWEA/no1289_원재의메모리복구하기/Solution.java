package SWEA.no1289_원재의메모리복구하기;

import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		sc.nextLine();

		for (int a = 1; a <= T; a++) {
			int cnt = 0;
			String str = "";
			str = sc.nextLine();
			char[] s = str.toCharArray();
			char[] first = new char[s.length];
			for (int i = 0; i < s.length; i++)
				first[i] = '0';
			for (int i = 0; i < s.length; i++) {
				if (s[i] != first[i]) {
					if (first[i] == '1') {
						for (int j = i; j < s.length; j++)
							first[j] = '0';
					} else
						for (int j = i; j < s.length; j++)
							first[j] = '1';
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", a, cnt);
		}
		sc.close();
	}
}