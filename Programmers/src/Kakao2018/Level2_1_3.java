package Kakao2018;

import java.util.*;

public class Level2_1_3 {
	// 2018 KAKAO BLIND RECRUITMENT 1�� Level 2 �� ��° ���� ���� Ŭ�����͸�
	
	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
	}
	
    static int solution(String str1, String str2) {
        // �ڸ� ���ڿ�, ����Ƚ��
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        // ��� �ҹ��ڷ� ����
        stringCut(str1.toLowerCase(), map1);
        stringCut(str2.toLowerCase(), map2);
        
        if(map1.size() == 0 && map2.size() == 0)
            return 65536; // 1 * 65536
        
        int union = getUnion(map1, map2);
        int intersection = getIntersection(map1, map2);
        
        return (int)(((double)union / intersection) * 65536);
    }
    
    // �� ���ھ� ��� map�� �ֱ�
    static void stringCut(String str, HashMap<String, Integer> map) {
        for(int i=0;i<str.length() - 1;i++) {
            char now = str.charAt(i);
            char next = str.charAt(i + 1);
            
            if(now < 'a' || now > 'z')
                continue;
            if(next < 'a' || next > 'z') {
                i++;
                continue;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append(now).append(next);
            map.put(sb.toString(), map.getOrDefault(sb.toString() , 0) + 1);
        }
    }
    
    // �������� ���� ���ϱ�
    static int getUnion(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        int union = 0;
        
        for(String s : map1.keySet()) {
            if(!map2.containsKey(s)) 
                continue;
            // �� ���տ� ��� �����Ѵٸ� ������ ������ ���� ���� ����
            union += Math.min(map1.get(s), map2.get(s));
        }
        
        return union;
    }
    
    // �������� ���� ���ϱ�
    static int getIntersection(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        int intersection = 0;
        
        for(String s : map1.keySet()) {
            if(!map2.containsKey(s)) 
                intersection += map1.get(s);
            else {
                // �� ���տ� ��� �����Ѵٸ� ������ ������ ���� ���� ����
                intersection += Math.max(map1.get(s), map2.get(s));
                map2.remove(s);
            }
        }
        
        // map1�� ��ġ�� �� �����߱� ������ �ٷ� ������
        for(int i : map2.values()) 
            intersection += i;
        
        return intersection;
    }

}
