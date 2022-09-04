package SWEA.no1218_괄호짝짓기;

import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    static Stack<Character> stack;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 10;
 
        for (int t = 0; t < tc; t++) {
            int len = sc.nextInt();
 
            stack = new Stack<Character>();
            sc.nextLine();
            String str = sc.nextLine();
 
            int answer = 1;
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[')
                    stack.push(str.charAt(i));
                else {
                    if (check(str.charAt(i)) == 0) {
                        answer = 0;
                        break;
                    }
                }
            }
 
            System.out.printf("#%d %d\n", t + 1, answer);
        }
        sc.close();
    }
 
    static int check(char bracket) {
        switch (bracket) {
        case ']':
            if (stack.pop() == '[')
                return 1;
            else
                return 0;
        case '}':
            if (stack.pop() == '{')
                return 1;
            else
                return 0;
        case ')':
            if (stack.pop() == '(')
                return 1;
            else
                return 0;
        }
        return 1;
    }
}