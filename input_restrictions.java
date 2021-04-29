package oopm_pro;
import java.util.*;

public class input_restrictions {

	public static void main(String[] args)
	{
		
		int n=0;
		while(true)
		{
			int c=0;
			try
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("enter the number : ");
				n=sc.nextInt();
				sc.nextLine();
				
			}
			catch(Exception e)
			{
				System.out.println("wrong input");
				c=1;
				continue;
			}
			if(c==0)
			{
				break;
			}
			
		}
	}
	
}
