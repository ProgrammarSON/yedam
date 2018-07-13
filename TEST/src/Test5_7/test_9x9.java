package Test5_7;

import java.util.Scanner;

public class test_9x9 {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
				
		int money=0;
		int input;
		int sel;
		
		while(true)
		{
			System.out.print("투입할 금액? ");
			input = sc.nextInt();
			money += input;			
			System.out.println("현재금액: "+ money + "원");
			
			money = Machine(money);
			if(money < 0)
			{
				System.out.println("반환된 금액: " + money);
				break;
			}
			
			System.out.print("잔돈을 반환 하시겠습니까 ? 1(yes) or 2(No)");
			sel = sc.nextInt();
			
			if(sel == 1)
			{
				System.out.println("반환된 금액: " + money);
				break;
			}
		}
	}
	
	public static int Machine(int m) {
		System.out.println("음료 선택 ? 1:콜라(800) 2:생수(400) 3:쥬스(1000)");
		int choice = sc.nextInt();
		
		switch(choice)
		{
			case 1:
				if(m<800) 
				{
					System.out.println("돈이 부족합니다.(현재금액 " + m + "원)");
					return m;
				}
				m -= 800;
				System.out.println("콜라가 배출 되었습니다.");
				break;
			case 2:
				if(m<400) 
				{
					System.out.println("돈이 부족합니다.(현재금액 " + m + "원)");
					return m;
				}
				m -= 400;
				System.out.println("생수가 배출 되었습니다.");
				break;
			case 3:
				if(m<1000) 
				{
					System.out.println("돈이 부족합니다.(현재금액 " + m + "원)");
					return m;
				}
				m -= 1000;
				System.out.println("주스가 배출 되었습니다.");
				break;
			default :
				System.out.println("해당상품이 없습니다.");
		}
		return m;
	}
}
