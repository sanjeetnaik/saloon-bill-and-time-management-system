package oopm_pro;

import java.util.*;
public class page0 {

	public static void main(String[] args)
	{
		
		//barber input ServicesAndPrices
		int n1=0;
		while(true)
		{
			int c=0;
			try
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter 1 to execute the program as saloon manager");
				System.out.println("Enter 2 to execute the program as user");
				System.out.println("enter the number : ");
				n1=sc.nextInt();
				sc.nextLine();
				
			}
			catch(Exception e)
			{
				System.out.println("wrong input");
				c=1;
				continue;
			}
			if(n1!=1&&n1!=2)
			{
				System.out.println("Wrong input .... please enter again");
				continue;
			}
			if(c==0)
			{
				break;
			}
			
		}
		ServicesAndPrices bj=new ServicesAndPrices();
		signup1 ob=new signup1();
		login ob1=new login();
		userselect ob2=new userselect();
		//manager input
		if(n1==1)
		{
			bj.main(args);
		}
		//user input
		else
		{
			System.out.println("1. Sign Up");
			System.out.println("2. Log In");
			
			int n=0;
			while(true)
			{
				
				try
				{
					Scanner sc=new Scanner(System.in);
					System.out.println("enter the choice : ");
					n=sc.nextInt();
					sc.nextLine();
					
				}
				catch(Exception e)
				{
					System.out.println("wrong input");
					continue;
				}
				if(n==1)
				{
					ob.main(args);
					ob1.main(args);
				}
				else if (n==2)
				{
					ob1.main(args);
				}
				else
				{
					System.out.println("wrong input");
					continue;
				}
				
				break;
				
			}
			
			ob2.main(args);
		}

	}
	
}
