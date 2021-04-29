package oopm_pro;

import java.io.*;
import java.util.*;

public class login
{
	String usrnm;
	String arr[];
	int mc=0;
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		login obj=new login();
		
		int counter=0;
		
		try 
		{
			  File myObj = new File("signup.txt");
			  
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine())
		      {
		    	  String temp=myReader.nextLine();
		    	  counter++;
		      }
		      
		      myReader.close();
		    } 
		catch (FileNotFoundException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }

		obj.arr=new String[counter];
		int eee=0;
		try 
		{
			  File myObj = new File("signup.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine())
		      {
		    	  String temp=myReader.nextLine();
		    	  obj.arr[eee]=temp;
		    	  eee++;
		      }
		      myReader.close();
		    } 
		catch (FileNotFoundException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
		
		System.out.println("Enter the credentials ");

		int check1=0;
		int check2=0;
		while(true)
		{
			try
			{
				System.out.print("Username : ");
				String temp=sc.nextLine();
				check1=obj.checkmeusrnm(temp);
				if(check1==1)
				{
					obj.usrnm=temp;
					System.out.print("Password : ");
					String temp1=sc.nextLine();
					check2=obj.checkmepwd(temp1);
				}
				
			}
			catch (Exception e) { 
		            System.out.println("exception occoured" + e); 
		    }
			if(check1==1&&check2==0)
			{
				System.out.println("Password entered is wrong !!!!");
				continue;
			}
			else if(check1==0&&check2==0)
			{
				System.out.println("This username is not registered! Please sign up !!");
				continue;
			}
			
			else if(check1==1&&check2==1)
			{
				System.out.println("Welcome "+obj.usrnm);
				break;
			}
			else
			{
				System.out.println("kya chalray");
				System.out.println(check1);
				System.out.println(check2);
				continue;
			}

		}
	}

	public void printme()
	{
		System.out.println("Total bill is : "+usrnm);
	}
	
	public  int checkmeusrnm(String usrnm)
	{
		int counter=0;
		int c=0;
		for(int i=0;i<arr.length;i=i+2)
  	    {  		 
  		  if(usrnm.equalsIgnoreCase(arr[i]))
  		  {
  			  c=1;
  			  mc=i;
  			  break;
  		  }
  	    }
		return c;
	}
	
	public int checkmepwd(String pwd)
	{
		int counter=0;
		int c=0;
		for(int i=1;i<arr.length;i=i+2)
  	    {
	  		 if(i>mc)
	  		 {
	  			 if(pwd.equalsIgnoreCase(arr[i]))
	  			 {
	  				 c=1;
	  			 }
	  			 break;
	  		 }
  	    }
		return c;
	}
}


