/*Author: Eric Boilard                                                                                      */
/*Version: 1.0                                                                                              */
/*Class: CS320 QA Test                                                                                      */
/*Description: This java file creates an object called contact of type contact to be used in ContactService */

public class Contact { //name of the class
	
	String iD;           //instance variables for the class
	String firstName;
	String lastName;
	String phoneNumber;
	String address;
	final String DEFAULT = "some default value";
	final String DEFAULT_INT = "8675309";
	
	Contact() {
	    this.iD = DEFAULT;//Constructor method to update contact fields
	    this.firstName = DEFAULT;
	    this.lastName = DEFAULT;
	    this.phoneNumber = DEFAULT_INT;
	    this.address = DEFAULT;
	  }

	  Contact(String contactId) {//Constructor method to update contact fields
	    contactID(contactId);
	    this.firstName = DEFAULT;
	    this.lastName = DEFAULT;
	    this.phoneNumber = DEFAULT_INT;
	    this.address = DEFAULT;
	  }

	  Contact(String contactId, String firstName) {//Constructor method to update contact fields
	    contactID(contactId);
	    contactFName(firstName);
	    this.lastName = DEFAULT;
	    this.phoneNumber = DEFAULT_INT;
	    this.address = DEFAULT;
	  }

	  Contact(String contactId, String firstName, String lastName) {//Constructor method to update contact fields
	    contactID(contactId);
	    contactFName(firstName);
	    contactLName(lastName);
	    this.phoneNumber = DEFAULT_INT;
	    this.address = DEFAULT;
	  }

	  Contact(String contactId, String firstName, String lastName,
	          String phoneNumber) {//Constructor method to update contact fields
	    contactID(contactId);
	    contactFName(firstName);
	    contactLName(lastName);
	    contactPhoneNum(phoneNumber);
	    this.address = DEFAULT;
	  }

	  Contact(String contactId, String firstName, String lastName,
	          String phoneNumber, String address) {//Constructor method to update contact fields
	    contactID(contactId);
	    contactFName(firstName);
	    contactLName(lastName);
	    contactPhoneNum(phoneNumber);
	    contactAddress(address);
	  }
	
	
	public String getID() { //List of getters that return the contact object fields
		return iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	
	protected void contactID(String iD) {  //List of setters that accept an argument for the variable, then check it, then store it
		if (iD == null || iD.length() > 10){
			throw new IllegalArgumentException("Invalid input");
		}
		this.iD = iD;
	}
	protected void contactFName(String firstName) {
		if (firstName == null || firstName.length() > 10){
			throw new IllegalArgumentException("Invalid input");
		}
		this.firstName = firstName;
	}
	protected void contactLName(String lastName) {
		if (lastName == null || lastName.length() > 10){
			throw new IllegalArgumentException("Invalid input");
		}
		this.lastName = lastName;
	}
	protected void contactPhoneNum(String phoneNumber) {
		if (phoneNumber == null || phoneNumber.length() > 10){
			throw new IllegalArgumentException("Invalid input");
		}
		this.phoneNumber = phoneNumber;
	}
	protected void contactAddress(String address) {
		if (address == null || address.length() > 30){
			throw new IllegalArgumentException("Invalid input");
		}
		this.address = address;
	}
	
}