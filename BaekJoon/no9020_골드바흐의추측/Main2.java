package BaekJoon.no9020_골드바흐의추측;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		for (int t = 0; t < tc; t++) {
			int n = sc.nextInt();
			Eratos(n);

			int answer = 0;
			for (int i = 0; i < Eratos(n).size(); i++) {
				for (int j = 0; j < Eratos(n).size(); j++) {
					if (Eratos(n).get(j) == (n - Eratos(n).get(i))) {
						answer = Eratos(n).get(i);
					}
				}
				if (Eratos(n).get(i) >= n / 2)
					break;
			}

			sb.append(n - answer).append(" ").append(answer).append("\n");
		}
		System.out.print(sb.toString());
		sc.close();
	}

	static List<Integer> Eratos(int n) {
		List<Integer> prime_number = new ArrayList<Integer>();
		for (int i = 1; i <=n; i++)
			prime_number.add(i);
		for (int i = 2; i < n; i++) {
			for (int j = 2; j < n / j; j++) {
				prime_number.remove(Integer.valueOf(i * j));
			}
		}
		return prime_number;
	}
}