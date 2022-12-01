package Kakao2018;

import java.util.*;

public class Level3_1_1 {
	// 2018 KAKAO BLIND RECRUITMENT 1�� Level 3 ù ��° ���� ��Ʋ����
	
    static int[] bus;
    static ArrayList<Integer>[] crew;
    
	public static void main(String[] args) {
		String[] timetable = {"07:12", "08:00", "08:05", "08:55"}; // "08:54"
		System.out.println(solution(1, 1, 4, timetable));
	}
	
    static String solution(int n, int t, int m, String[] timetable) {
        bus = new int[n];
        crew = new ArrayList[n];
        
        for(int i=0;i<n;i++)
            crew[i] = new ArrayList<>();
        
        bus[0] = 540;
        
        for(int i=1;i<n;i++)
            bus[i] = bus[i - 1] + t;
        
        Arrays.sort(timetable);
        
        for(String str : timetable) 
            findBus(strToInt(str), n, m);
        
        int ans = getAnswer(n, m);
        return intToStr(ans);
    }
    
    static int strToInt(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
    
    static String intToStr(int m) {
        StringBuilder sb = new StringBuilder();
        if(m / 60 < 10)
            sb.append('0');
        sb.append(m / 60);
        
        m %= 60;
        sb.append(':');
        
        if(m < 10)
            sb.append('0');
        sb.append(m);
        
        return sb.toString();
    }
    
    static void findBus(int min, int n, int m) {
        // ���� ���� �������� �ʰ� �����ߴٸ� �ƹ� ������ Ÿ�� ����
    	if(bus[n - 1] < min)
            return;
        
    	// ���� �ڸ��� �����ְ� ũ�� ���� �ð��� ���� �����ð��� ���ų� �۴ٸ� �ش� ���� ž��
        for(int i=0;i<n;i++) {
        	if(bus[i] >= min && crew[i].size() < m) {
        		crew[i].add(min);
        		break;
        	}
        }

    }
    
    static int getAnswer(int n, int m) {
    	// ������ ������ �ڸ��� ����ִٸ� ���� ��� �ð��� ����
        if(crew[n - 1].size() < m)
            return bus[n - 1];
        
        // ������ ������ �� á�ٸ� ���� �ʰ� ž���� ũ�纸�� 1�� ���� ����
        return crew[n - 1].get(m - 1) - 1;
    }

}
