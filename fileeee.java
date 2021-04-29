package oopm_pro;

import java.io.*;
import java.util.*;

public class fileeee {
	public static void main(String[] args) {
		try {
			File myObj = new File("bill.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		int n;
		int[] abra = new int[] {
			200,
			300,
			400
		};
		String[] cadabra = new String[] {
			"haircut",
			"hairwash",
			"haircolor"
		};
		String[] slot = new String[] {
			"9:30-10",
			"10-10:30",
			"10:30-11"
		};

		Scanner sc = new Scanner(System.in);

		System.out.println("enter number services");

		n = sc.nextInt();
		double billamt = 0;

		String services = "";
		String slotdetails = "";
		for (int i = 0; i < n; i++) {
			System.out.println("Enter index of the servie");
			int index = sc.nextInt();
			billamt = billamt + abra[index - 1];
			services = services + " | " + cadabra[index - 1];
			slotdetails = slotdetails + " | " + slot[index - 1];

		}
		double totalbill = billamt + 0.18 * billamt;
		services = services + " | ";
		slotdetails = slotdetails + " | ";
		String dash="-----------------------------------------------------------";
	
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
		System.out.println("Reading data from the files : ");
		System.out.println("\n");

		try {
			File myObj = new File("bill.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		// sc.close();
	}
}
