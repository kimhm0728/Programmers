package Kakao2018;

import java.util.*;

public class Level1_1_1 {
	// 2018 KAKAO BLIND RECRUITMENT 1�� Level 1���� ù ��° ��Ʈ ����

	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
	}
	
    static int solution(String dartResult) {
        ArrayList<Integer> num = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int size = 0;
        
        for(char c : dartResult.toCharArray()) {
            if(c >= '0' && c <= '9') // ������ ���
                sb.append(c);
            else if(c >= 'A' && c <= 'Z') { // ���ʽ��� ���
                num.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
                size++;
                
                if(c == 'S')
                    continue;
                else if(c == 'D') 
                    num.set(size - 1, (int)Math.pow(num.get(size - 1), 2));
                else if(c == 'T') 
                    num.set(size - 1, (int)Math.pow(num.get(size - 1), 3));
            }
            else {
                if(c == '*') { // �ɼ��� ���
                    num.set(size - 1, num.get(size - 1) * 2);
                    if(size != 1)
                        num.set(size - 2, num.get(size - 2) * 2);
                }
                else if(c == '#') {
                    num.set(size - 1, num.get(size - 1) * -1);
                }
            }
            
        }
        
        return num.get(0) + num.get(1) + num.get(2);
    }

}
