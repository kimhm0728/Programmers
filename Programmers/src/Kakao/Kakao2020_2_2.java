package Kakao;

import java.util.*;

public class Kakao2020_2_2 {

	public static void main(String[] args) {
		System.out.println(solution("()))((()"));
	}
	
    static String solution(String p) {
        if(isCorrect(p))
            return p;
        return setBracket(p);
    }
    
    static String setBracket(String w) {
        if(w.equals(""))
            return w;
    
        int idx = separate(w);
        StringBuilder u = new StringBuilder(w.substring(0, idx + 1));
        StringBuilder v = new StringBuilder(w.substring(idx + 1, w.length()));
        StringBuilder sb = new StringBuilder();
        
        if(isCorrect(u.toString())) 
            sb.append(u).append(setBracket(v.toString()));
        else {
            sb.append('(').append(setBracket(v.toString())).append(')');
            u.deleteCharAt(u.length() - 1);
            u.deleteCharAt(0);
            for(int i=0;i<u.length();i++) {
                char c = u.charAt(i);
                if(c == '(')
                    u.setCharAt(i, ')');
                else
                    u.setCharAt(i, '(');
            }
            sb.append(u);
        }
        
        return sb.toString();
    }
    
    // �ùٸ� ��ȣ ���ڿ��̶�� 0��, �ƴ϶�� u, v�� �и��� �ε��� ��ȯ
    static boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            else if(c == ')') {
                if(stack.empty()) 
                    return false;
                else
                    stack.pop();
            }
        }
        
        return stack.empty() ? true : false;
    }
    
    static int separate(String s) {
        int open = 0;
        int close = 0;
        int ret = 0;
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(')
                open++;
            else if(c == ')')
                close++;
            // ���� ��ȣ�� �ݴ� ��ȣ�� ������ ó������ ������ ���� �������� u, v �и�
            if(open == close) {
                ret = i;
                break;
            }
        }
        
        return ret;
    }

}
