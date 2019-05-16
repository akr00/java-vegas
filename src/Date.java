// Made By: Aiden Ridgeway
// Created on 3/29/19
// Purpose is to use all skills learned so far in a single project
public class Date {

	private int day;
	private int month;
	private int year;
	public Date(int day, int month, int year) {
		
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(day>0 && day <32) {
			this.day = day;
		}
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month> 0 && month <13) {
			this.month = month;
		}
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return (day + "/" + month + "/" + year);
	}
	
	
	
	
}
