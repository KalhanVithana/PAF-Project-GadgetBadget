package com.user.fund.model;

public class fund {

	private int id;
	private String name;
	private String date;
	private String description;
	private float amount;
	private String recipient_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getRecipient_name() {
		return recipient_name;
	}
	public void setRecipient_name(String recipient_name) {
		this.recipient_name = recipient_name;
	}
	
	
	@Override
	public String toString() {
		return "Fund [id=" + id + ", name=" + name + ", date=" + date + ", description=" + description + ", amount="
				+ amount + ", recipient_name=" + recipient_name + "]";
	}
	
	
}
