package oopm_pro;

import java.awt.*;
import java.util.*;

public class button_ls {
	
	 public static void create2(String show1, String show2)
     {
        Frame f = new Frame();
        Button b1 = new Button(show1);
        Button b2 = new Button(show2);
        
        b1.setBounds(50,100,100,50);
        b2.setBounds(170,100,100,50);
        
        f.setLayout(null);
        f.setSize(300,300);
        f.setVisible(true);
        
        f.add(b1);
        f.add(b2);
        
       
     }
	 
	 public static void main(String[] args)
	 {
		 Scanner sc=new Scanner(System.in);
		 create2("Barber", "User");
		 sc.close();
	 }

}
