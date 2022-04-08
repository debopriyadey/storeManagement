package com.storeManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemManagement {

	static Connection con = DBConnection.createConnection();

	public static void showItems() {
		try {

			String query = "SELECT * FROM storeitems";
			Statement statement = con.createStatement();

			ResultSet resSet = statement.executeQuery(query);

			while (resSet.next()) {
				int id = resSet.getInt(1);
				String itemName = resSet.getString("itemName");
				int itemCount = resSet.getInt("itemCount");
				int itemPrice = resSet.getInt("itemPrice");

				System.out.println("Id " + id);
				System.out.println("Item Name " + itemName);
				System.out.println("Item Count " + itemCount);
				System.out.println("Item Price " + itemPrice);
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("Unable to show data" + e);
		}
	}

	public static boolean insertItem(Item it) {

		boolean flag = false;

		try {

			String query = "INSERT INTO storeitems(itemName, itemCount, itemPrice) VALUES(?,?,?)";
			PreparedStatement prepState = con.prepareStatement(query);

			prepState.setString(1, it.getItemName());
			prepState.setInt(2, it.getItemCount());
			prepState.setInt(3, it.getItemPrice());

			prepState.executeUpdate();
			flag = true;

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Sorry unable to insert data");
		}

		return flag;
	}

	public static boolean deleteItem(String itNameDel) {
		
		String query = "DELETE FROM storeitems WHERE itemName = ? ";
		boolean flag = false;
		try {
			PreparedStatement prepState = con.prepareStatement(query);
			prepState.setString(1, itNameDel);
			prepState.executeUpdate();
			flag = true;

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Sorry unable to insert data");
		}

		return flag;
	}

	public static Item searchAnItem(String itNameUpdate) {

		String query = "SELECT * FROM storeItems WHERE itemName = ?";
		try {
			PreparedStatement prepState = con.prepareStatement(query);
			prepState.setString(1, itNameUpdate);
			ResultSet resSet = prepState.executeQuery();
			while (resSet.next()) {
				int id = resSet.getInt(1);
				String itemName = resSet.getString("itemName");
				int itemCount = resSet.getInt("itemCount");
				int itemPrice = resSet.getInt("itemPrice");

				System.out.println("Id " + id);
				System.out.println("Item Name " + itemName);
				System.out.println("Item Count " + itemCount);
				System.out.println("Item Price " + itemPrice);
				System.out.println();
				Item ItemDetails = new Item(id, itemName, itemCount, itemPrice);
				return ItemDetails;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void updateItemCount(String itNameUpdate, int reqCount) {
		
		try {
			Item itDetail = ItemManagement.searchAnItem(itNameUpdate);
			int curCount = itDetail.getItemCount();
			int finalCount = curCount + reqCount;
			String query = "UPDATE storeItems SET itemCount = ? WHERE itemName = ?";
			
			System.out.println("cur "+curCount+",req "+reqCount+",Totcount "+ finalCount);
			PreparedStatement prepState = con.prepareStatement(query);
			prepState.setInt(1, finalCount);
			prepState.setString(2, itNameUpdate);
			
			prepState.executeUpdate();
			Item updatedItem = ItemManagement.searchAnItem(itNameUpdate);
			
		} catch (Exception e) {
			System.out.println("Unable to update data");
		}
		
	}
}
