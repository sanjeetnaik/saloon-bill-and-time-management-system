package oopm_pro;
import java.io.File;
import java.util.*;
import java.io.*;

public class file_test1 {
	
	public static void main(String[] ags)
	{
		char arr[][]=new char[22][7];
		int counter=0;
		Scanner sc=new Scanner(System.in);
		try
		{
			File myObj = new File("n1.txt");
		    Scanner myReader = new Scanner(myObj);
		    
		    while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        for(int i=0;i<data.length();i++)
		        {
		        	arr[counter][i]=data.charAt(i);
		        }
		        counter++;
		      }
		      myReader.close();
		}
		catch(Exception e)
		{
			System.out.println("Erorr ugh!!");
		}
		System.out.println(arr.length);
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		 
		flushme();
		
		
	}

	
	public static void flushme()
	{
		try {
	         OutputStream os = new FileOutputStream("n1.txt");
	         os.flush();
	      } 
		catch (Exception e)
		{
			System.out.println("Eroooooooor!!!");
	    }
	}
}
