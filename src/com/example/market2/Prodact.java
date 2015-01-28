package com.example.market2;



public class Prodact {

	private boolean onList = false;
	private String name;
	private int amount,id;
	
	
	private  Prodact() {
		name = "";
		amount = 0;
	}
	
	
	public Prodact(String name) {
		super();
		this.name = name;
		this.amount = 0;
	}
	
	public Prodact(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public Prodact(Prodact p) {
		super();
		this.name = p.name;
		this.amount = 0;
		
	}





	


	public boolean isOnList() {
		return onList;
	}


	public void setOnList(boolean onList) {
		this.onList = onList;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int price) {
		this.amount = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
