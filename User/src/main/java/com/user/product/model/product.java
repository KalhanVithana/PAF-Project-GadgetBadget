package com.user.product.model;

//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class product {
	private int id;
	private String name;
	private String type;
	private float price;
	private String description;
	private int quantity;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "product [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", description="
				+ description + ", quantity=" + quantity + "]";
	}
	
	
	
}
