package Kakao2018;

import java.util.*;

public class Level2_3_4 {
	// 2018 KAKAO BLIND RECRUITMENT 3�� Level 2 �� ��° ���� ��ݱװ�

    static String[][] alpha = {{"A#", "a"}, {"G#", "g"}, {"F#", "f"}, {"D#", "d"}, {"C#", "c"}};
    static String ans = "(None)";
    static int ansTime = 0;
	
	public static void main(String[] args) {
		String[] musicinfos = {"11:50,12:04,HELLO,CDEFGAB", "12:57,13:11,BYE,CDEFGAB"};
		System.out.println(solution("ABCDEFG", musicinfos));
	}
	
    static String solution(String m, String[] musicinfos) {
    	String target = replaceMusic(m);
    	
    	for(int i=0;i<musicinfos.length;i++) {
            String[] music = getMusic(musicinfos[i]);
            isSameMusic(target, music[0], music[1]); // �׿��� ����� ��ε�, ����, ����� ��
        }
    	
        return ans;
    }
    
    static String[] getMusic(String str) {
    	StringTokenizer st = new StringTokenizer(str, ",");
        int start = strToInt(st.nextToken()); // ���� �ð�
        int end = strToInt(st.nextToken()); // �� �ð�
        int time = end - start;
        
        String title = st.nextToken(); 
        String music = replaceMusic(st.nextToken()); // ���� ��

        int len = music.length();
        String[] ret = new String[2];
        ret[0] = title;
        ret[1] = music.repeat(time / len) + music.substring(0, time % len);
        // ��� �ð��� �� ���̷� ���� �� ��ŭ �ݺ�, �ݺ� �� ���� �ð��� �ִٸ� ���̱�
        
        return ret;
    }
    
    // HH:MM ������ �ð��� ������ ��ȯ
    static int strToInt(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
    
    // # ���� ���� �ٸ� ���ĺ����� ġȯ
    static String replaceMusic(String m) {
    	String ret = m;
    	for(String[] a : alpha)
            ret = ret.replaceAll(a[0], a[1]);
    	
        return ret;
    }
    
    static void isSameMusic(String target, String title, String music) {
        int len = music.length();
    	if(music.contains(target) && ansTime < len) {
            ans = title;
            ansTime = len;
        }
    }
}
