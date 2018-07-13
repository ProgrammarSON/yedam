package Algorithm;

import java.util.Scanner;

public class haha {
	static int op[] = new int[4];
	static int num[] = new int[12];
	static int N;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int T;
		T = sc.nextInt();
		
		
		for(int i=1; i<=T; i++)
		{
			N = sc.nextInt();
			for(int j=0; j<4; j++) op[j] = sc.nextInt();
			for(int j=0; j<N; j++) num[j] = sc.nextInt();
				
		}
		
		
	}
	
	static void dfs(int n, int value) {
		if(n == N)
		{
			
		}
		
	}
}
