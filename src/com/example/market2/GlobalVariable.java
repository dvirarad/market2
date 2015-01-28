package com.example.market2;

import java.util.ArrayList;

import android.app.Application;

public class GlobalVariable extends Application{
	private ArrayList<Prodact> _prodactList;//List chosen by user
	private ArrayList<Prodact> _mega,_bitan,_shoferSal,_victory;
	private int[] megaPrice,bitanPrice,shoferSalPrice,victoryPrice;
	private final int NUM_ITEM =14;


	public ArrayList<Prodact> getProdactList() {
		return _prodactList;
	}

	public void setProdactList(ArrayList<Prodact> prodactList) {
		_prodactList = new ArrayList<Prodact>();
		this._prodactList.addAll(prodactList);

	}
	public int getNUM_ITEM() {
		return NUM_ITEM;
	}

	public void GlobalConstractor(){


		megaPrice = new int[NUM_ITEM];
		bitanPrice = new int[NUM_ITEM];
		shoferSalPrice = new int[NUM_ITEM];
		victoryPrice = new int[NUM_ITEM];
	}

	public void setAllPrice(){
		for (int i = 0; i <  NUM_ITEM; i++) {
			this.megaPrice[i]= (int) (Math.random()*10 +1);
			this.bitanPrice[i]= (int) (Math.random()*9 +1);
			this.shoferSalPrice[i]= (int) (Math.random()*11 +1);
			this.victoryPrice[i] = (int) (Math.random()*11 +1);
		}
	}





	public int getMegaPrice(int x){
		return megaPrice[x];			
	}

	public int getBitanPrice(int x){
		return bitanPrice[x];			
	}
	public int getShoferSalPrice(int x){
		return shoferSalPrice[x];			
	}
	public int getVictoryPrice(int x){
		return victoryPrice[x];			
	}

	public ArrayList<Prodact> get_prodactList() {
		return _prodactList;
	}

	public void set_prodactList(ArrayList<Prodact> _prodactList) {
		this._prodactList = _prodactList;
	}

	public ArrayList<Prodact> get_mega() {
		return _mega;
	}

	public void set_mega(ArrayList<Prodact> _mega) {
		this._mega = _mega;
	}

	public ArrayList<Prodact> get_shoferSal() {
		return _shoferSal;
	}

	public void set_shoferSal(ArrayList<Prodact> _shoferSal) {
		this._shoferSal = _shoferSal;
	}

	public ArrayList<Prodact> get_victory() {
		return _victory;
	}

	public void set_victory(ArrayList<Prodact> _victory) {
		this._victory = _victory;
	}

}
