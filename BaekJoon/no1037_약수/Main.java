package BaekJoon.no1037_약수;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] divisor = new int[n];
		for (int i = 0; i < n; i++)
			divisor[i] = sc.nextInt();

		Arrays.sort(divisor);
		int ans = divisor[0]*divisor[n-1];
		
		System.out.println(ans);
		sc.close();
	}
}
