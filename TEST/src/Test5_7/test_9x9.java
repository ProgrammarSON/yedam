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
			System.out.print("������ �ݾ�? ");
			input = sc.nextInt();
			money += input;			
			System.out.println("����ݾ�: "+ money + "��");
			
			money = Machine(money);
			if(money < 0)
			{
				System.out.println("��ȯ�� �ݾ�: " + money);
				break;
			}
			
			System.out.print("�ܵ��� ��ȯ �Ͻðڽ��ϱ� ? 1(yes) or 2(No)");
			sel = sc.nextInt();
			
			if(sel == 1)
			{
				System.out.println("��ȯ�� �ݾ�: " + money);
				break;
			}
		}
	}
	
	public static int Machine(int m) {
		System.out.println("���� ���� ? 1:�ݶ�(800) 2:����(400) 3:�꽺(1000)");
		int choice = sc.nextInt();
		
		switch(choice)
		{
			case 1:
				if(m<800) 
				{
					System.out.println("���� �����մϴ�.(����ݾ� " + m + "��)");
					return m;
				}
				m -= 800;
				System.out.println("�ݶ� ���� �Ǿ����ϴ�.");
				break;
			case 2:
				if(m<400) 
				{
					System.out.println("���� �����մϴ�.(����ݾ� " + m + "��)");
					return m;
				}
				m -= 400;
				System.out.println("������ ���� �Ǿ����ϴ�.");
				break;
			case 3:
				if(m<1000) 
				{
					System.out.println("���� �����մϴ�.(����ݾ� " + m + "��)");
					return m;
				}
				m -= 1000;
				System.out.println("�ֽ��� ���� �Ǿ����ϴ�.");
				break;
			default :
				System.out.println("�ش��ǰ�� �����ϴ�.");
		}
		return m;
	}
}
