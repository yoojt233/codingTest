package BaekJoon.no1032_명령프롬프트;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = sc.next();
		}
		
		/* 첫 줄과 나머지 줄 비교
		 * 어차피 하나라도 다르면 ? 출력.
		 */
		for (int j = 0; j < str[0].length(); j++) {
			boolean check = true;
			for (int i = 0;i<n; i++) {
				if(str[0].charAt(j) != str[i].charAt(j)) {
					check = false;
				}
			}
			if(check == true) {
				sb.append(str[0].charAt(j));
			}
			else
				sb.append("?");
		}
		System.out.print(sb.toString());
		sc.close();
	}
}
