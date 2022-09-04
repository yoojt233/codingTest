package BaekJoon.no1697_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] check = new int[100001];

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		while (!q.isEmpty()) {
			int temp = q.poll();
			if (temp == K)
				break;
			if (temp - 1 >= 0 && check[temp - 1] == 0) {
				q.offer(temp - 1);
				check[temp - 1] = check[temp] + 1;
			}
			if (temp + 1 <= 100000 && check[temp + 1] == 0) {
				q.offer(temp + 1);
				check[temp + 1] = check[temp] + 1;
			}
			if (temp * 2 <= 100000 && check[temp * 2] == 0) {
				q.offer(temp * 2);
				check[temp * 2] = check[temp] + 1;
			}
		}
		System.out.print(check[K]);
	}
}
