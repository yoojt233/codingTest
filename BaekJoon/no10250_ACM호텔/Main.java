package BaekJoon.no10250_ACM호텔;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			
			// a는 호실, b는 층
			int cnt = 0, a = 1, b = 0;
			
			// 층 수 1 증가, 꼭대기층 넘어가면 호실 1 증가
			while (cnt < n) {
				b++;
				if(b > h) {
					a++;
					b=1;
				}
				cnt++;
			}
			
			// 호실이 한 자리 수일 경우, 0 삽입
			if(a < 10)
				sb.append(b).append("0").append(a).append("\n");
			else
				sb.append(b).append(a).append("\n");
		}
		System.out.print(sb.toString());
		sc.close();
	}
}
