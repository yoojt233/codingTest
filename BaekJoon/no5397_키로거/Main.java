package BaekJoon.no5397_키로거;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			Stack<Character> front = new Stack<>();
			Stack<Character> back = new Stack<>();

			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				switch (str.charAt(i)) {
				case '<':
					if (!front.isEmpty())
						back.push(front.pop());
					break;
				case '>':
					if (!back.isEmpty())
						front.push(back.pop());
					break;
				case '-':
					if (!front.isEmpty())
						front.pop();
					break;
				default:
					front.push(str.charAt(i));
					break;
				}
			}
			while(!front.isEmpty())
				back.push(front.pop());
			
			while(!back.isEmpty())
				sb.append(back.pop());
			
			sb.append("\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
