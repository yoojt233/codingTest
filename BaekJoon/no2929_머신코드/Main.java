package BaekJoon.no2929_머신코드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		Pattern pattern = Pattern.compile("[A-Z]"); // 대문자 정규 표현식
		Matcher matcher = pattern.matcher(str);

		int ans = 0;
		while (matcher.find()) {

			// 대문자의 위치에서 nop를 지금까지 몇 개 넣었는지
			int cur = matcher.start() + ans;

			// 4의 배수이면 nop 필요 없음.
			if (cur % 4 == 0)
				continue;
			else // nop 몇 개 필요?
				ans += (4 - cur % 4);
		}

		System.out.print(ans);
		br.close();
	}
}
