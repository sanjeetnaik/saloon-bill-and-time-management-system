package oopm_pro;

import java.io.*;
import java.util.*;

public class signup1 {
	
	String arr[];
	
	public  void flushme()
	{
		try {
	         OutputStream os = new FileOutputStream("signup.txt");
	         os.flush();
	      } 
		catch (Exception e)
		{
			System.out.println("Eroooooooor!!!");
	    }
	}
	

	public int checkme(String usrnm)
	{
		int c=0;
		try 
		{
			  File myObj = new File("signup.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine())
		      {
		    	  String temp=myReader.nextLine();
		    	  for(int i=0;i<arr.length;i=i+2)
		    	  {
		    		  if(usrnm.equalsIgnoreCase(temp))
		    		  {
		    			  c=1;
		    		  }
		    	  }
		      }
		      myReader.close();
		    } 
		catch (FileNotFoundException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
		return c;
		
	}
	
	public static void main(String [] args)
	{
		
		
		signup1 obj=new signup1();
		int counter=0;
		Scanner sc=new Scanner (System.in);
		try 
		{
		      File myObj = new File("signup.txt");
		      if (myObj.createNewFile()) 
		      {
		        System.out.println("File created: " + myObj.getName());
		      } else 
		      {
		       
		      }
		}
		catch(IOException e)
		{
			System.out.println("File already exists.");
		}
		catch(Exception e)
		{
			System.out.println("Erooor!");
		}
		
		
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
		
		try 
		{
			  File myObj = new File("signup.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine())
		      {
		    	  String temp=myReader.nextLine();
		    	  for(int j=0;j<obj.arr.length;j++)
		    	  {
		    		  obj.arr[j]=temp;
		    	  }
		      }
		      myReader.close();
		    } 
		catch (FileNotFoundException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		 }
		
		int check=0;
		for(int i=0;i<1;i++)
		{
			int see=0;  //to check if usrnm coincides with someone else
			while(true)
			{
				try
		        { 
					see=0;
					Scanner sc1=new Scanner(System.in);
		        	System.out.println("Write the username : ");
					String usrnm=sc1.nextLine();
					see=obj.checkme(usrnm);
					if(see==1)
					{
						System.out.println("This username already exists....choose a different one!");
						continue;
					}
		        	BufferedWriter out = new BufferedWriter( 
		            new FileWriter("signup.txt", true)); 
		            out.write(usrnm); 
		            out.write("\n");
		            out.close(); 
		        } 
				catch (Exception e) { 
		            System.out.println("exception occoured" + e); 
		        } 
				break;
			}
			
			
		
		}
		
		try
        { 
			Scanner sc1=new Scanner(System.in);
        	System.out.println("Write the password : ");
			String pwd=sc1.nextLine();
        	BufferedWriter out = new BufferedWriter( 
            new FileWriter("signup.txt", true)); 
            out.write(pwd); 
            out.write("\n");
            out.close(); 
        } 
		catch (Exception e) { 
            System.out.println("exception occoured" + e); 
        } 
		System.out.println("");
		System.out.println("Sign up successfull");
	}
}
