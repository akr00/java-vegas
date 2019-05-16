// Made By: Aiden Ridgeway
// Created on 3/29/19
// Purpose is to use all skills learned so far in a single project
public class Player {

	private Name name;
	private Date birthday;
	private int balance;
	
	public Player(Name name, Date birthday, int balance) {
		
		this.name = name;
		
		this.birthday = birthday;
		this.balance = balance;
	}

	public Name getName() {
		return name;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setName(Name name) {
		this.name = name;
	}

	

	

	

	public int getbalance() {
		return balance;
	}

	

	@Override
	public String toString() {
		return " Name= " + name + " " +  " balance= " + balance ;
	}
	
	
	
	
	
}
