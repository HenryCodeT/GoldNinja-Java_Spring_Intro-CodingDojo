package com.codingdojo.ninjagoldgame.models;

public class GoldGame {
	private String stage;
	private int num;
	private int isAdd;
	private String date;
	
	public GoldGame( String stage, int num, int isAdd, String date) {
		this.stage = stage;
		this.num = num;
		this.isAdd = isAdd; 
		this.date = date;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getIsAdd() {
		return isAdd;
	}

	public void setIsAdd(int isAdd) {
		this.isAdd = isAdd;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
