package com.storeManagement;

public class Item {
	private int itemId;
	private String itemName;
	private int itemCount;
	private int itemPrice;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Item(int itemId, String itemName, int itemCount, int itemPrice) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCount = itemCount;
		this.itemPrice = itemPrice;
	}

	public Item(String itemName, int itemCount, int itemPrice) {
		this.itemName = itemName;
		this.itemCount = itemCount;
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Item{" + "itemId=" + itemId + ", itemName='" + itemName + '\'' + ", itemCount=" + itemCount
				+ ", itemPrice=" + itemPrice + '}';
	}
}
