package oopm_pro;

import java.io.*;

import java.util.*;
public class ServicesAndPrices {
	
	String ser[];
	int pri[];
	int slo[];
	String superr[];
	
	
	public void storemefile()
	{
		try 
		{
		      File myObj = new File("services.txt");
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
		while(true)
		{
			try
	        { 
				
	        	 for (int i=0;i<ser.length;i++) 
	        	 {
	        		 Scanner sc1=new Scanner(System.in);
	 	        	BufferedWriter out = new BufferedWriter( 
	 	            new FileWriter("services.txt", true)); 
	        		 String s=superr[i];
	        		
	                 out.write(s); 
	 	            out.write("\n");
	 	          
	 	            
	 	             
	                 out.close();
	             }

	           
	        } 
			catch (Exception e) { 
	            System.out.println("exception occoured" + e); 
	        } 			
			break;
		}
	}
	 
	 
    public static void main(String[] args) {
        
    	ServicesAndPrices obj=new ServicesAndPrices();

        Scanner sc = new Scanner(System.in);
       
        System.out.print("Enter the number of services: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        obj.pri=new int[n];
        obj.ser=new String[n];
        obj.slo=new int[n];
        obj.superr=new String[n];
        

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Service name: ");
            obj.ser[i] = sc.nextLine();
            while (true) {
                int c = 0;
                try {
                    Scanner scc = new Scanner(System.in);
                    System.out.print("Enter price for " + obj.ser[i] + ": ");
                     obj.pri[i]= scc.nextInt();
                    scc.nextLine();
                    System.out.print("Enter Time required for " +obj.ser[i]+ " (1 for 30 mins 2 for 60 mins): ");
                    obj.slo[i]=scc.nextInt();
                    scc.nextLine();
                    
                    obj.superr[i]=obj.ser[i]+" "+obj.pri[i]+" "+obj.slo[i];
                    
                } catch (Exception e) {
                    
                    c=1;
                    System.out.println("Wrong input.... Enter again");

                }
                if(c==0){
                    break;
                }
            }

           

        }
       
        System.out.println();

        obj.storemefile();
    }
}