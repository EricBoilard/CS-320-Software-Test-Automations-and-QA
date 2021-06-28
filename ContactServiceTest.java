/*Author: Eric Boilard                                                                                      */
/*Version: 1.0                                                                                              */
/*Class: CS320 QA Test                                                                                      */
/*Description: Test file to run tests on the contact service file methods                                   */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	  protected String iD, firstNameTest, lastNameTest, phoneNumberTest, //setup variables for passing variables
	      addressTest;
	  protected String failLengthID, failLengthFirstName, failLengthLastName, //setup variables for failing variables
	  failLengthPhoneNumber, failLengthAddress;

  @BeforeEach
  void setUp() {//passing variables
    iD = "3875623";
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
  void newContactTest() {//tests running against all methods
    ContactService service = new ContactService();
    service.newContact();
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(0).getID()),
        ()
            -> assertEquals("some default value",
                            service.getContactList().get(0).getFirstName()),
        ()
            -> assertEquals("some default value",
                            service.getContactList().get(0).getLastName()),
        ()
            -> assertEquals("8675309",
                            service.getContactList().get(0).getPhoneNumber()),
        ()
            -> assertEquals("some default value",
                            service.getContactList().get(0).getAddress()));
    service.newContact(firstNameTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(1).getID()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(1).getFirstName()),
        ()
            -> assertEquals("some default value",
                            service.getContactList().get(1).getLastName()),
        ()
            -> assertEquals("8675309",
                            service.getContactList().get(1).getPhoneNumber()),
        ()
            -> assertEquals("some default value",
                            service.getContactList().get(1).getAddress()));
    service.newContact(firstNameTest, lastNameTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(2).getID()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(2).getFirstName()),
        ()
            -> assertEquals(lastNameTest,
                            service.getContactList().get(2).getLastName()),
        ()
            -> assertEquals("8675309",
                            service.getContactList().get(2).getPhoneNumber()),
        ()
            -> assertEquals("some default value",
                            service.getContactList().get(2).getAddress()));
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(3).getID()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(3).getFirstName()),
        ()
            -> assertEquals(lastNameTest,
                            service.getContactList().get(3).getLastName()),
        ()
            -> assertEquals(phoneNumberTest,
                            service.getContactList().get(3).getPhoneNumber()),
        ()
            -> assertEquals("some default value",
                            service.getContactList().get(3).getAddress()));
    service.newContact(firstNameTest, lastNameTest, phoneNumberTest,
                       addressTest);
    assertAll(
        "service",
        ()
            -> assertNotNull(service.getContactList().get(4).getID()),
        ()
            -> assertEquals(firstNameTest,
                            service.getContactList().get(4).getFirstName()),
        ()
            -> assertEquals(lastNameTest,
                            service.getContactList().get(4).getLastName()),
        ()
            -> assertEquals(phoneNumberTest,
                            service.getContactList().get(4).getPhoneNumber()),
        ()
            -> assertEquals(addressTest,
                            service.getContactList().get(4).getAddress()));
  }

  @Test
  void deleteContactTest() {
    ContactService service = new ContactService();
    service.newContact();
    assertThrows(Exception.class, () -> service.deleteContact(iD));
    assertAll(()
                  -> service.deleteContact(
                      service.getContactList().get(0).getID()));
  }

  @Test
  void updateFirstNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.contactFName(service.getContactList().get(0).getID(),
                            firstNameTest);
    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.contactFName(
                         service.getContactList().get(0).getID(),
                         failLengthFirstName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.contactFName(
                         service.getContactList().get(0).getID(), null));
    assertThrows(Exception.class,
                 () -> service.contactFName(iD, firstNameTest));
  }

  @Test
  void updateLastNameTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.contactLName(service.getContactList().get(0).getID(),
                           lastNameTest);
    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.contactLName(
                         service.getContactList().get(0).getID(),
                         failLengthLastName));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.contactLName(
                         service.getContactList().get(0).getID(), null));
    assertThrows(Exception.class,
                 () -> service.contactLName(iD, lastNameTest));
  }

  @Test
  void updatePhoneNumberTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.contactPhoneNum(service.getContactList().get(0).getID(),
                              phoneNumberTest);
    assertEquals(phoneNumberTest,
                 service.getContactList().get(0).getPhoneNumber());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.contactPhoneNum(
                         service.getContactList().get(0).getID(),
                         failLengthPhoneNumber));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.contactPhoneNum(
                         service.getContactList().get(0).getID(),
                         failLengthPhoneNumber));
    
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.contactPhoneNum(
                         service.getContactList().get(0).getID(), null));
    assertThrows(Exception.class,
                 () -> service.contactPhoneNum(iD, phoneNumberTest));
  }

  @Test
  void updateAddressTest() throws Exception {
    ContactService service = new ContactService();
    service.newContact();
    service.contactAddress(service.getContactList().get(0).getID(),
                          addressTest);
    assertEquals(addressTest, service.getContactList().get(0).getAddress());
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.contactAddress(
                         service.getContactList().get(0).getID(),
                         failLengthAddress));
    assertThrows(IllegalArgumentException.class,
                 ()
                     -> service.contactAddress(
                         service.getContactList().get(0).getID(), null));
    assertThrows(Exception.class,
                 () -> service.contactAddress(iD, addressTest));
  }
}
