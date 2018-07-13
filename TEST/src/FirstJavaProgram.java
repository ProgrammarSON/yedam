import java.util.*;

interface DIStack<E>{
	public boolean push(E item);
	public E pop();
}

class DCStack<E> implements DIStack<E>{
	private Deque<E> deq;
	
	public DCStack(Deque<E> d) {
		deq = d;
	}
	
	public boolean push(E item) {
		return deq.offerFirst(item);
	}
	
	public E pop() {
		return deq.pollFirst();
	}
}

public class FirstJavaProgram {

	public static void main(String[] args) {
		 Random ran = new Random();

	     int ran_lotto_num[] = new int[6];
	     int j=0;
	        for(int i = 0 ; i < 6 ; i++) { //i는 추출 값 j는 저장된 값
	            ran_lotto_num[i] = ran.nextInt(10)+1;
	            
	            for (; j < i; j++)
	            {
	            	if(ran_lotto_num[i] == ran_lotto_num[j])
	            	{
	            		j--;
	            		break;
	            	}
	            }                
	            

	       }
	        for(int k = 0;  k< ran_lotto_num.length ; k++){
	            System.out.print(ran_lotto_num[k] + ", ");
	        }
	}
}