
// import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import com.storeManagement.*;

public class start {
	public static void main(String[] args) throws IOException {
		int choice;
		System.out.println("Welcome to store management system");
		System.out.println(
				"1. Add Items " + "\n 2. Update Items" + "\n 3. Delete Item " + "\n 4. Show Item list " + "\n 5. Exit");
		while (true) {
			System.out.println("Enter your choice: ");

			BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(sc.readLine());

			switch (choice) {
			case 1:
				System.out.println("Add a product");
				System.out.println("Enter Item Name: ");
				String itName = sc.readLine();

				System.out.println("Enter Item Count: ");
				int itCount = Integer.parseInt(sc.readLine());

				System.out.println("Enter Item Price: ");
				int itPrice = Integer.parseInt(sc.readLine());

				Item ItemDetails = new Item(itName, itCount, itPrice);
				boolean ans = ItemManagement.insertItem(ItemDetails);
				if (ans) {
					System.out.println("Item added successfully");
				} else {
					System.out.println("Sorry unable to insert data");
				}
				break;

			case 2:
				System.out.println("Update Item");
				System.out.println("Enter Item name");
				
				String itNameUpdate = sc.readLine();
				String reqCountS = sc.readLine();
				int reqCount = Integer.parseInt(reqCountS);
				ItemManagement.updateItemCount(itNameUpdate, reqCount);
				break;

			case 3:
				System.out.println("Delete a product");
				System.out.println("Enter the name of item to delete");

				String itNameDel = sc.readLine();

				boolean ansDel = ItemManagement.deleteItem(itNameDel);
				if (ansDel) {
					System.out.println("Item deleted successfully");
				} else {
					System.out.println("Sorry unable to delete item");
				}
				break;

			case 4:
				System.out.println("Showing all item details");
				ItemManagement.showItems();
				break;

			case 5:
				System.out.println("Thank You For Using Our Management System");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid input");
			}
		}
	}
}
