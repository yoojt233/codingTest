package Programmers.no92335_k진수에서소수개수구하기;

class Solution {

	public static int solution(int n, int k) {
		String str = Integer.toString(n, k); // n을 k 진수로 변환
		String[] number = str.split("0"); // 0을 기준으로 split

		int ans = 0;
		for (String s : number) {
			if (s.equals("") || s.equals("1"))
				continue;

			if (isPrime(Long.parseLong(s)))
				++ans;
		}

		return ans;
	}

	// 소수 판별
	private static boolean isPrime(long temp) {
		for (int i = 2; i <= (int) Math.sqrt(temp); ++i) {
			if (temp % i == 0)
				return false;
		}
		return true;
	}
}