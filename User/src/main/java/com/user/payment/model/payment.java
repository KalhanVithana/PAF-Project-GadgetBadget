package com.user.payment.model;


public class payment {
	private int id;
	private int accountNo;
	private float amount;
	private String type;
	private String date;
	private String description;
	private String buyerName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	@Override
	public String toString() {
		return "Payment [id=" + id + ", accountNo=" + accountNo + ", amount=" + amount + ", type=" + type + ", date="
				+ date + ", description=" + description + ", buyerName=" + buyerName + "]";
	}
}

