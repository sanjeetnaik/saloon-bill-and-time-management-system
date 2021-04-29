package oopm_pro;
import java.util.*;
import java.io.*;
public class weekt 
{
	 String []  slots=new String [22];
	 String []  days= {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	 char slotnum[]=new char[22];
	 char arr[][]=new char[22][7];
	 int slot;
	 String returnee;

	 String[] spc= {"        ","         ","           ","           ","          ","         ","        "};
	
	weekt()
	{
		int temp=10;
		for(int i=0;i<22;i++)
		{
			
			slots[i]=temp+"-"+temp+".30";
			slots[++i]=temp+".30"+"-";
			temp++;
			slots[i]+=temp;
		}
		int counter=0;
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
		temp=65;
		for(int i=0;i<22;i++)
		{
			slotnum[i]=(char)temp;
			temp++;
		}
	}
	
	public  void displayy()
	{

		iniarr();
		
		System.out.println("  Slots "+"   Timing   "+"  Monday  "+" Tuesday"+"  Wednesday  "+" Thursday  "+" Friday  "+" Saturday  "+" Sunday");
		for(int i=0;i<22;i++)
		{
			System.out.println("    "+slotnum[i]+"     "+slots[i]+"      "+arr[i][0]+spc[0]+arr[i][1]+spc[1]+arr[i][2]+spc[3]+arr[i][3]+spc[4]+arr[i][4]+spc[5]+arr[i][5]+spc[6]+arr[i][6]);
		}
	}
	
	public char book(int nos,int dayno)
	{
		Scanner sc=new Scanner(System.in);

		if(nos==2)
		{
			while(true)
			{
				try 
				{
					char slot=sc.nextLine().charAt(0);
					int slotnum=(int)slot-65;
					int nextslot=(int)slot-64;
					if(slotnum>=0&&slotnum<=21&&nextslot>=0&&nextslot<=21)
					{
						if(arr[slotnum][dayno]=='O'&&arr[nextslot][dayno]=='O')
						{
							System.out.println("Booking confirmed ! ");
							returnee+=" "+slots[slotnum]+" "+slots[nextslot];
							arr[slotnum][dayno]='X';
							arr[nextslot][dayno]='X';
							return slot;
						}
						else if(arr[slotnum][dayno]=='O'&&arr[nextslot][dayno]=='X')
						{
							System.out.println("You require 2 slots second slot is not available...enter again ");
							continue;
						}
						else if(arr[slotnum][dayno]=='X')
						{
							System.out.println("Slot is not available...enter again ");
							continue;
						}
						else if(arr[slotnum][dayno]=='O'&&arr[nextslot][dayno]=='-')
						{
							System.out.println("You require 2 slots second slot is not available...enter again ");
							continue;
						}
						else if(arr[slotnum][dayno]=='-')
						{
							System.out.println("Slot is not available...enter again ");
							continue;
						}
					}
					else
					{
						if(nextslot>=0&&nextslot<=21)
						{
							System.out.println("No such slot available");
							continue;
						}
						else if(slotnum>=0&&slotnum<=21)
						{
							System.out.println("You need 2 slots for this service...second slot not available ");
							continue;
						}
						else
						{
							System.out.println("Wrong slot entered...try again");
							continue;
						}
					}
				}
				catch(Exception e)
				{
					System.out.println("enter again.......");
				}
			}
		}
		else
		{
			while(true)
			{
				try 
				{
					char slot=sc.nextLine().charAt(0);
					int slotnum=(int)slot-65;
					if(slotnum>=0&&slotnum<=21)
					{
						if(arr[slotnum][dayno]=='O')
						{
							returnee+=" "+slots[slotnum];
							System.out.println("Booking confirmed ! ");
							arr[slotnum][dayno]='X';
							return slot;
						}
						
						else if(arr[slotnum][dayno]=='X')
						{
							System.out.println("Slot is not available...enter again ");
							continue;
						}
						
						else if(arr[slotnum][dayno]=='-')
						{
							System.out.println("Slot is not available...enter again ");
							continue;
						}
					}
					else
					{
						System.out.println("Wrong slot entered...try again");
						continue;
					}
				}
				catch(Exception e)
				{
					System.out.println("enter again.......");
				}
			}
		}
	}
	
	public void iniarr()
	{
		flushme();
		
		try
        { 
        	BufferedWriter out = new BufferedWriter( 
            new FileWriter("n1.txt", true)); 
        	for(int i=0;i<22;i++)
        	{
        		String temp=""+arr[i][0]+arr[i][1]+arr[i][2]+arr[i][3]+arr[i][4]+arr[i][5]+arr[i][6];
        		 out.write(temp); 
                 out.write("\n");
        	}
           
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
		catch (Exception e) { 
            System.out.println("exception occoured" + e); 
        } 
		
	}
	
	public void flushme1()
	{
		try {
	         OutputStream os = new FileOutputStream("n1.txt");
	         os.flush();
	         
	      } 
		catch (Exception e)
		{
			System.out.println("Eroooooooor!!!");
	    }
		
		try
        { 
        	BufferedWriter out = new BufferedWriter( 
            new FileWriter("n1.txt", true)); 
        	for(int i=0;i<22;i++)
        	{
        		String temp="OOOOOOO";
        		 out.write(temp); 
                 out.write("\n");
        	}
           
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
		catch (Exception e) { 
            System.out.println("exception occoured" + e); 
        } 
	}

	public  void flushme()
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

	
	public static String bookme( int slott)
	{
		weekt ob=new weekt();		
		Scanner sc=new Scanner(System.in);
		int c=0;
		while(true)
		{
			int dayno=0;
			int ch=0;
			String day="";
			int slot=slott;
			boolean b=false;
			int bro=0;
			while(true)
			{
				int c1=0;
				try
				{
					
					ch=1;
					
					
				}
				catch(Exception e)
				{
					System.out.println("wrong input");
					c1=1;
				}
				if(c1==0)
				{
					break;
				}
				
			}
			
			if(ch==1)
			{				
				while(true)
				{
					int c1=0;
					day="";
					try
					{
						Scanner sc2=new Scanner(System.in);
						ob.displayy();
						System.out.println("Enter the day to be added in : ");
						day=sc2.nextLine();
						day=day.toLowerCase();
						for(int i=0;i<ob.days.length;i++)
						{
							if(ob.days[i].toLowerCase().compareTo(day)==0)
							{
								c1=1;
								dayno=i;
								ob.returnee="";
								ob.returnee=ob.days[i].toLowerCase();
								b=true;
								break;
							}
						}
					}
					catch(Exception e)
					{
						System.out.println("wrong input .... enter again \n");
						c1=0;
						continue;
					}
					if(c1==0)
					{
						System.out.println("wrong input .... enter again \n");
						continue;
					}
					else
					{
						
						break;
					}
					
				}
				System.out.println("Choose the slot booking : ");
				if(dayno==0)
				{
					ob.book(slot,dayno);
				}
				else if(dayno==1)
				{
					ob.book(slot,dayno);
				}
				else if(dayno==2)
				{
					ob.book(slot,dayno);
				}
				else if(dayno==3)
				{
					ob.book(slot,dayno);
				}
				else if(dayno==4)
				{
					ob.book(slot,dayno);
				}
				else if(dayno==5)
				{
					ob.book(slot,dayno);
				}
				else
				{
					ob.book(slot,dayno);
				}

				ob.displayy();
			}

			break;
			
		}
		return ob.returnee;
	}
	
	public static void main(String[] args)
	{
		weekt obb=new weekt();
		obb.displayy();
		
	}
}
