package CodingTestKit;

import java.util.HashSet;
import java.util.Arrays;
import java.util.Iterator;

public class Greedy1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(6, new int[] {4, 2}, new int[] {3, 5}));
	}

    public static int solution(int n, int[] lost, int[] reserve) {
        int ans = n - lost.length;
        
        Arrays.sort(lost);
        HashSet<Integer> lostSet = new HashSet<Integer>();
        HashSet<Integer> reserveSet = new HashSet<Integer>();
        
        for(int i=0;i<lost.length;i++)
            lostSet.add(lost[i]);
        
        for(int i=0;i<reserve.length;i++)
            reserveSet.add(reserve[i]);
        
        Iterator <Integer>iter = lostSet.iterator();
        
        for(int i=0;i<lostSet.size();i++) {
            int s = iter.next();
            if(reserveSet.contains(s)) {
                ans++;
            	reserveSet.remove(s);
            }
            else if(reserveSet.contains(s - 1) && !lostSet.contains(s - 1)) {
                ans++;
                reserveSet.remove(s - 1);
            }
            else if(reserveSet.contains(s + 1) && !lostSet.contains(s + 1)) {
                ans++;
                reserveSet.remove(s + 1);
            }
        }
        
        return ans;
    }
}
