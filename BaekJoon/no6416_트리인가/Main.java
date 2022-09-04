package BaekJoon.no6416_트리인가;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int u = sc.nextInt();
		int v = sc.nextInt();
		int k = 1;
		while (u >= 0 && v >= 0) {
			boolean flag = true;

			if (u == 0 && v == 0) {
				u = sc.nextInt();
				v = sc.nextInt();
				continue;
			}

			if (flag)
				sb.append("Case ").append(k++).append(" is a tree.\n");
			else
				sb.append("Case ").append(k++).append(" is not a tree.\n");
		}

		System.out.print(sb.toString());
		sc.close();
	}
}
