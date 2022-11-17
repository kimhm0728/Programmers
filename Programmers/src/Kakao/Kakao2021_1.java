package Kakao;

public class Kakao2021_1 {

	public static void main(String[] args) {
		System.out.println(solution("z-+.^."));
	}
	
    static String solution(String new_id) {
        // 1�ܰ�
        String ans = new_id.toLowerCase();
        
        StringBuilder sb = new StringBuilder(ans);
        
        for(int i=0;i<sb.length();i++) {
            char c = sb.charAt(i);
            // 2�ܰ�
            if((c < 'a' || c > 'z') && (c < '0' || c > '9') && c != '-' && c != '_' && c != '.')
                sb.setCharAt(i, '*');
        }
        
        ans = sb.toString().replaceAll("\\*", "");
    
        // 3�ܰ�
        ans = ans.replaceAll("\\.{2,}", "\\.");
        
        sb.setLength(0);
        sb.append(ans);
        
        // 4�ܰ�
        if(sb.charAt(0) == '.')
            sb.setCharAt(0, '*');
        if(sb.charAt(sb.length() - 1) == '.')
        	sb.setCharAt(sb.length() - 1, '*');
        
        ans = sb.toString().replaceAll("\\*", "");
        
        sb.setLength(0);
        sb.append(ans);
        
        // 5�ܰ�
        if(sb.length() == 0) 
            sb.append("a");
        // 6�ܰ�
        else if(sb.length() >= 16) {
            sb.setLength(15);
            if(sb.charAt(sb.length() - 1) == '.')
                sb.setCharAt(sb.length() - 1, '*');
            
            sb = new StringBuilder(sb.toString().replaceAll("\\*", ""));
        }
        // 7�ܰ�
        if(sb.length() <= 2)
            while(sb.length() < 3)
                sb.append(sb.charAt(sb.length() - 1));
        
        return sb.toString();
    }

}
