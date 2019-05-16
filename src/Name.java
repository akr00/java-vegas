// Made By: Aiden Ridgeway
// Created on 3/29/19
// Purpose is to use all skills learned so far in a single project
public class Name {

	private String firstName; 
	private char middleInitial; 
	private String lastName;
	
	public Name(String firstName, char middleInitial, String lastName) {
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
	} 
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		
		
		this.firstName = ( firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase() );
	}

	public char getMiddleName() {
		return middleInitial;
	}

	public void setMiddleName(String middleName) {
		this.middleInitial = ( middleName.toUpperCase().charAt(0));
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = ( lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase() );
	}

	
	public String toString() {
		
		
			return ( firstName + " "+ middleInitial+ ". " + lastName+ " " );	
		
		
	} 
	
	
	
}
