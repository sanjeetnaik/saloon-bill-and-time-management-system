package oopm_pro;
import java.util.*;

public class weekly 
{
	 String []  slots=new String [22];
	 String []  days= {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
	 String []  apply=new String[22];
	 char slotnum[]=new char[22];
	 char arr[][]=new char[22][7];

	 String[] spc= {"        ","         ","           ","           ","          ","         ","        "};
	
	weekly()
	{
		int temp=10;
		for(int i=0;i<22;i++)
		{
			
			slots[i]=temp+"-"+temp+".30";
			slots[++i]=temp+".30"+"-";
			temp++;
			slots[i]+=temp;
		}
		for(int i=0;i<22;i++)
		{
			apply[i]="O";
		}
		temp=65;
		for(int i=0;i<22;i++)
		{
			slotnum[i]=(char)temp;
			temp++;
		}
	}
	
	public  void display(weekly mo,weekly tu,weekly we,weekly th,weekly fr,weekly sa,weekly su)
	{
		System.out.println("  Slots "+"   Timing   "+"  Monday  "+" Tuesday"+"  Wednesday  "+" Thursday  "+" Friday  "+" Saturday  "+" Sunday");
		for(int i=0;i<22;i++)
		{
			System.out.println("    "+slotnum[i]+"     "+slots[i]+"      "+mo.apply[i]+spc[0]+tu.apply[i]+spc[1]+we.apply[i]+spc[3]+th.apply[i]+spc[4]+fr.apply[i]+spc[5]+sa.apply[i]+spc[6]+su.apply[i]);
		}
	}
	
	public char book(int nos)
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
						if(apply[slotnum]=="O"&&apply[nextslot]=="O")
						{
							System.out.println("Booking confirmed ! ");
							apply[slotnum]="X";
							apply[nextslot]="X";
							return slot;
						}
						else if(apply[slotnum]=="O"&&apply[nextslot]=="X")
						{
							System.out.println("You require 2 slots second slot is not available...enter again ");
							continue;
						}
						else if(apply[slotnum]=="X")
						{
							System.out.println("Slot is not available...enter again ");
							continue;
						}
						else if(apply[slotnum]=="O"&&apply[nextslot]=="-")
						{
							System.out.println("You require 2 slots second slot is not available...enter again ");
							continue;
						}
						else if(apply[slotnum]=="-")
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
						if(apply[slotnum]=="O")
						{
							System.out.println("Booking confirmed ! ");
							apply[slotnum]="X";
							return slot;
						}
						
						else if(apply[slotnum]=="X")
						{
							System.out.println("Slot is not available...enter again ");
							continue;
						}
						
						else if(apply[slotnum]=="-")
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


	public static void main(String[] args)
	{
		
		weekly ob=new weekly();
		
		Scanner sc=new Scanner(System.in);
		weekly mo=new weekly();
		weekly tu=new weekly();
		weekly we=new weekly();
		weekly th=new weekly();
		weekly fr=new weekly();
		weekly sa=new weekly();
		weekly su=new weekly();
		
		System.out.println("a");
		
		int c=0;
		while(true)
		{
			int dayno=0;
			int ch=0;
			String day="";
			boolean b=false;
			System.out.println("b");
			while(true)
			{
				int c1=0;
				try
				{
					Scanner sc1=new Scanner(System.in);
					System.out.println("Enter 1 to see the booking ");
					System.out.println("Enter 2 to exit ");
					ch=sc1.nextInt();
					sc1.nextLine();
					
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
					int c1=-1;
					day="";
					try
					{
						Scanner sc1=new Scanner(System.in);
						ob.display(mo, tu, we, th, fr, sa, su);
						System.out.println("Enter the day to be added in : ");
						day=sc.nextLine();
						day=day.toLowerCase();
						for(int i=0;i<ob.days.length;i++)
						{
							if(ob.days[i].toLowerCase().compareTo(day)==0)
							{
								c1=i;
								dayno=i;
								b=true;
								break;
							}
							else
							{
								c1=-1;
							}
						}
					}
					catch(Exception e)
					{
						System.out.println("wrong input .... enter again \n");
						c1=-1;
					}
					if(c1==-1)
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
					mo.book(1);
				}
				else if(dayno==1)
				{
					tu.book(1);
				}
				else if(dayno==2)
				{
					we.book(1);
				}
				else if(dayno==3)
				{
					th.book(1);
				}
				else if(dayno==4)
				{
					fr.book(1);
				}
				else if(dayno==5)
				{
					sa.book(1);
				}
				else
				{
					su.book(1);
				}
				ob.display(mo, tu, we, th, fr, sa, su);
				
				
			}
			else
			{
				break;
			}
			
			
		}
		
		
		sc.close();
	}
}
