package oopm_pro;

import java.io.*;
import java.util.*;

public class userselect extends ServicesAndPrices
{
	
	String ser[];
	int pri[];
	int slo[];
	int nos;
	int total;
	String help[];
	String serv[];
	
	userselect()
	{

		int n=0;
		try 
		{
			  File myObj = new File("services.txt");
		      Scanner myReader = new Scanner(myObj);
		      int i=0;
		      while (myReader.hasNextLine())
		      {

		    	  String temp=myReader.nextLine();
		    	  StringTokenizer st = new StringTokenizer(temp," \n");  
		    	  while (st.hasMoreTokens()) {  
		    		
		    		  st.nextToken();  
		    	         n++;
		    	     }  
		        }
		      myReader.close();
		     
		}
		catch (FileNotFoundException e) 
		{
		      System.out.println("An error occurred.");
		     
		 }
		catch(Exception e)
		{
			System.out.println(" error occurred.");
		      
		}
		n=n/3;
		ser=new String[n];
		pri=new int[n];
		slo=new int[n];
		
		
		
		try 
		{
			  File myObj = new File("services.txt");
		      Scanner myReader = new Scanner(myObj);
		      int i=0;
		      while (myReader.hasNextLine())
		      {
		    	  String temp=myReader.nextLine();
		    	  StringTokenizer st1 = new StringTokenizer(temp," \n"); 
		    	 
		    	  
		    	    ser[i]=st1.nextToken();
		    	    pri[i]=Integer.parseInt(st1.nextToken());
		    	    slo[i]=Integer.parseInt(st1.nextToken());
		    	   i++;
		     
		    }
		      myReader.close();
		}
		catch(Exception e)
		{
			System.out.println("An error occurred.");
		}
		
	}
	
	public void display()
	{
		for(int i=0;i<ser.length;i++)
		{
			System.out.println("Service number : "+(i+1));
			System.out.println("Service : "+ser[i]);
			System.out.println("Price : "+pri[i]);
		}
	}
	
	
	public static void main(String[] args)
	{

		login obj2=new login();
		ServicesAndPrices obj1=new ServicesAndPrices();
		userselect ob=new userselect();
		weekt ob1=new weekt();	
		for(int v=0;v<7;v++)
		{
			int ch3=0;
			for(int tr=0;tr<3;tr++)
			{
				int c1=0;
				try
				{					
					Scanner scc2=new Scanner(System.in);
					System.out.println("Enter 1 reserve booking ");
					System.out.println("Enter 2 to see the slots ");
					System.out.println("Enter 3 to see the booking ");
					System.out.println("Enter 4 to exit ");
					ch3=scc2.nextInt();
					scc2.nextLine();
					
				}
				catch(Exception ex)
				{
					System.out.println("wrong inputtttttt");
					ex.printStackTrace();
					c1=1;
					continue;
				}
				if(c1==0)
				{
					break;
				}
			}
			
			
			
			if(ch3==1)
			{
				ob.display();
				while(true)
				{
					int c=0;
					try
					{
						Scanner sc2=new Scanner(System.in);
						System.out.println("Enter the number of services you want");
						ob.nos=sc2.nextInt();
						sc2.nextLine();
						ob.help=new String[ob.nos];
						ob.serv=new String[ob.nos];
						
					}
					catch(Exception e)
					{
						System.out.println("wrong input");
						c=1;
						continue;
					}
					if(ob.nos>ob.ser.length||ob.nos<=0)
					{
						System.out.println("kitna udayega bc!");
						continue;
					}
					if(c==0)
					{
						break;
					}
					
				}
				
				for(int i=0;i<ob.nos;i++)
				{
					int sern=0;
					while(true)
					{
						int c2=0;
						try
						{
							Scanner sc3=new Scanner(System.in);
							System.out.println("Enter service number : ");
							sern=sc3.nextInt();
							sc3.nextLine();
							sern--;
							ob.total+=ob.pri[sern];
							
						}
						catch(Exception exx)
						{
							System.out.println("wrong input");
							c2=1;
							continue;
						}
						
						if(c2==0)
						{
							
							int slott=ob.slo[sern];
							System.out.println(slott);
							ob.serv[i]=ob.ser[sern];
							ob.help[i]=ob1.bookme(slott);
							break;
						}
						
					}
					
				}
				
				//bill display
				//obj2.printme();
				double billamt = 0;
				String services = "";
				String slotdetails = "";
				
				for (int i = 0; i < ob.help.length; i++)
				{
					
					billamt = billamt + ob.total;
					services = services + " | " + ob.serv[i];
					slotdetails = slotdetails + " | " + ob.help[i];

				}
				double totalbill = billamt + 0.18 * billamt;
				services = services + " | ";
				slotdetails = slotdetails + " | ";
				String dash="------------------------------------------------------------------------------------------";
			
				try {

						BufferedWriter out = new BufferedWriter(
						new FileWriter("bill.txt", true));
						out.write(dash+"\n");
					out.write("   Your services are: " + services+"\n");
					out.write(dash+"\n");

					out.write("   Your services cost: " + billamt+"\n");
					out.write(dash+"\n");

					out.write("   Your slot timings are: " + slotdetails+"\n");
					out.write(dash+"\n");

					out.write("   Tax(18%): " + 0.18 * billamt+"\n");
					out.write(dash+"\n");

					out.write("   Your total bill is:        " + totalbill+"\n");
					out.write(dash+"\n");

					out.close();
				} catch (IOException e) {
					System.out.println("exception occoured" + e);
				} catch (Exception e) {
					System.out.println("exception occoured" + e);
				}

				System.out.println("\n");
				System.out.println("Printing your bill: ");
				System.out.println("\n");

				System.out.println(dash+"\n");
				System.out.println("   Your services are: " + services+"\n");
				System.out.println(dash+"\n");
				System.out.println("   Your services cost: " + billamt+"\n");
				System.out.println(dash+"\n");
				System.out.println("   Your slot timings are: " + slotdetails+"\n");
				System.out.println(dash+"\n");
				System.out.println("   Tax(18%): " + 0.18 * billamt+"\n");
				System.out.println(dash+"\n");
				System.out.println("   Your total bill is:        " + totalbill+"\n");
				System.out.println(dash+"\n");

				
			}
			
			else if(ch3==2)
			{
				ob1.main(args);
				
			}
			else if(ch3==3)
			{
				double billamt = 0;
				String services = "";
				String slotdetails = "";
				for (int i = 0; i < ob.help.length; i++)
				{
					
					billamt = billamt + ob.total;
					services = services + ob.serv[i]+ " | " ;
					slotdetails = slotdetails +  ob.help[i]+" | " ;

				}

				System.out.println(services);
				System.out.println(slotdetails);
			}
			else
			{
				break;
			}
		}
		
	}
}
