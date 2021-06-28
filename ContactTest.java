/*Author: Eric Boilard                                                                                      */
/*Version: 1.0                                                                                              */
/*Class: CS320 QA Test                                                                                      */
/*Description: Test file to test methods in contact.java                                                    */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
	
	public class ContactTest {
		  protected String iD, firstNameTest, lastNameTest, phoneNumberTest,//declaring variables for passing
		      addressTest;
		  protected String failLengthID, failLengthFirstName, failLengthLastName, //declaring variables for failing
		  failLengthPhoneNumber, failLengthAddress;
		   
		  @BeforeEach
		  void setUp() {
		    iD = "3875623";//passing variables
		    firstNameTest = "Eric";
		    lastNameTest = "Boilard";
		    phoneNumberTest = "8675309";
		    addressTest = "2500 River road Manch. NH";
		    
		    failLengthID = "1111111111111111";//failing variables
		    failLengthFirstName = "This is a really long name that should fail the test";
		    failLengthLastName = "This is also a really long name";
		    failLengthPhoneNumber = "1111111111111111";
		    failLengthAddress = "This is a super long address that should trigger a fail";
		  }
		  @Test
		  void zeroOutOfFiveTest() {//running tests for constructors
		    Contact contact = new Contact();
		    assertAll("constructor",
		              ()
		                  -> assertNotNull(contact.getID()),
		              ()
		                  -> assertNotNull(contact.getFirstName()),
		              ()
		                  -> assertNotNull(contact.getLastName()),
		              ()
		                  -> assertNotNull(contact.getPhoneNumber()),
		              () -> assertNotNull(contact.getAddress()));
		  }
		  @Test
		  void oneOutOfFiveTest() {
		    Contact contact = new Contact(iD);
		    assertAll("constructor one",
		              ()
		                  -> assertEquals(iD, contact.getID()),
		              ()
		                  -> assertNotNull(contact.getFirstName()),
		              ()
		                  -> assertNotNull(contact.getLastName()),
		              ()
		                  -> assertNotNull(contact.getPhoneNumber()),
		              () -> assertNotNull(contact.getAddress()));
		  }

		  @Test
		  void twoOutOfFiveTest() {
		    Contact contact = new Contact(iD, firstNameTest);
		    assertAll("constructor two",
		              ()
		                  -> assertEquals(iD, contact.getID()),
		              ()
		                  -> assertEquals(firstNameTest, contact.getFirstName()),
		              ()
		                  -> assertNotNull(contact.getLastName()),
		              ()
		                  -> assertNotNull(contact.getPhoneNumber()),
		              () -> assertNotNull(contact.getAddress()));
		  }

		  @Test
		  void threeOutOfFiveTest() {
		    Contact contact = new Contact(iD, firstNameTest, lastNameTest);
		    assertAll("constructor three",
		              ()
		                  -> assertEquals(iD, contact.getID()),
		              ()
		                  -> assertEquals(firstNameTest, contact.getFirstName()),
		              ()
		                  -> assertEquals(lastNameTest, contact.getLastName()),
		              ()
		                  -> assertNotNull(contact.getPhoneNumber()),
		              () -> assertNotNull(contact.getAddress()));
		  }

		  @Test
		  void fourOutOfFiveTest() {
		    Contact contact =
		        new Contact(iD, firstNameTest, lastNameTest, phoneNumberTest);
		    assertAll("constructor four",
		              ()
		                  -> assertEquals(iD, contact.getID()),
		              ()
		                  -> assertEquals(firstNameTest, contact.getFirstName()),
		              ()
		                  -> assertEquals(lastNameTest, contact.getLastName()),
		              ()
		                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
		              () -> assertNotNull(contact.getAddress()));
		  }

		  @Test
		  void fiveOutOfFiveTest() {
		    Contact contact = new Contact(iD, firstNameTest, lastNameTest,
		                                  phoneNumberTest, addressTest);
		    assertAll("constructor all",
		              ()
		                  -> assertEquals(iD, contact.getID()),
		              ()
		                  -> assertEquals(firstNameTest, contact.getFirstName()),
		              ()
		                  -> assertEquals(lastNameTest, contact.getLastName()),
		              ()
		                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
		              () -> assertEquals(addressTest, contact.getAddress()));
		  }

		  @Test
		  void updateFirstNameTest() {//running tests for setters
		    Contact contact = new Contact();
		    contact.contactFName(firstNameTest);
		    assertAll(
		        "First Name",
		        ()
		            -> assertEquals(firstNameTest, contact.getFirstName()),
		        ()
		            -> assertThrows(IllegalArgumentException.class,
		                            () -> contact.contactFName(null)),
		        ()
		            -> assertThrows(IllegalArgumentException.class,
		                            () -> contact.contactFName(failLengthFirstName)));
		  }

		  @Test
		  void updateLastNameTest() {
		    Contact contact = new Contact();
		    contact.contactLName(lastNameTest);
		    assertAll(
		        "Last Name",
		        ()
		            -> assertEquals(lastNameTest, contact.getLastName()),
		        ()
		            -> assertThrows(IllegalArgumentException.class,
		                            () -> contact.contactLName(null)),
		        ()
		            -> assertThrows(IllegalArgumentException.class,
		                            () -> contact.contactLName(failLengthLastName)));
		  }

		  @Test
		  void updatePhoneNumberTest() {
		    Contact contact = new Contact();
		    contact.contactPhoneNum(phoneNumberTest);
		    assertAll("Phone Number",
		              ()
		                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
		              ()
		                  -> assertThrows(IllegalArgumentException.class,
		                                  () -> contact.contactPhoneNum(null)),
		              ()
		                  -> assertThrows(
		                      IllegalArgumentException.class,
		                      () -> contact.contactPhoneNum(failLengthPhoneNumber)));
		              
		  }

		  @Test
		  void updateAddressTest() {
		    Contact contact = new Contact();
		    contact.contactAddress(addressTest);
		    assertAll("Address",
		              ()
		                  -> assertEquals(addressTest, contact.getAddress()),
		              ()
		                  -> assertThrows(IllegalArgumentException.class,
		                                  () -> contact.contactAddress(null)),
		              ()
		                  -> assertThrows(IllegalArgumentException.class,
		                                  () -> contact.contactAddress(failLengthAddress)));
		  }

		  @Test
		  void updateContactIdTest() {
		    Contact contact = new Contact();
		    contact.contactID(iD);
		    assertAll(
		        "contact ID",
		        ()
		            -> assertEquals(iD, contact.getID()),
		        ()
		            -> assertThrows(IllegalArgumentException.class,
		                            () -> contact.contactID(null)),
		        ()
		            -> assertThrows(IllegalArgumentException.class,
		                            () -> contact.contactID(failLengthID)));
		  }
		  
		  
		  

}
