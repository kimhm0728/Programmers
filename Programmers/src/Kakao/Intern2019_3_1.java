package Kakao;

public class Intern2019_3_1 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,4,5,3,2,1,4,2,5,1}, 3));
	}
	
    static int solution(int[] stones, int k) {
    	int ans = 0;
        int min = 1, max = 200000000;
        
        // �̺� Ž��
        while(min<=max) {
        	int mid = (min + max) / 2;
        	if(isToCross(mid, stones, k)) {
        		ans = Math.max(ans, mid);
        		min = mid + 1;
        	}
        	else
        		max = mid - 1;
        }
        
        return ans;
    }
    
    static boolean isToCross(int people, int[] arr, int k) {
    	int num = 0;

    	for(int i : arr) {
    		if(i - people < 0) 
    			num++; // ���� ���ϴ� ĭ�� ��ŭ ���ӵǴ��� ī��Ʈ
    		else 
    			num = 0;
    		if(k == num) // �� ���� �ǳ� �� �ִ� ĭ�� ������ �� �ǳʴ� �� 
    			return false;
    	}
    	return true;
    }

}
