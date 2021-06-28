/*Author: Eric Boilard                                                                                      */
/*Version: 1.0                                                                                              */
/*Class: CS320 QA Test                                                                                      */
/*Description: This java file references the Contact class by creating contact objects                      */
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

  private String newUniqueId;
  private List<Contact> contactList = new ArrayList<>(); //new object list of contact type called contact list

  {
	  newUniqueId = UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

  public void newContact() {
    Contact contact = new Contact(newUniqueId());
    contactList.add(contact);
  }

  public void newContact(String firstname) {
    Contact contact = new Contact(newUniqueId(), firstname);
    contactList.add(contact);
  }

  public void newContact(String firstname, String lastname) {
    Contact contact = new Contact(newUniqueId(), firstname, lastname);
    contactList.add(contact);
  }

  public void newContact(String firstname, String lastname,
                         String phonenumber) {
    Contact contact =
        new Contact(newUniqueId(), firstname, lastname, phonenumber);
    contactList.add(contact);
  }

  public void newContact(String firstname, String lastname, String phonenumber,
                         String address) {
    Contact contact =
        new Contact(newUniqueId(), firstname, lastname, phonenumber, address);
    contactList.add(contact);
  }

  
  
  
  
  public void deleteContact(String id) throws Exception {
    contactList.remove(searchForContact(id));
  }
  
  
  
  
  

  public void contactFName(String id, String firstName) throws Exception {
    searchForContact(id).contactFName(firstName);
  }

  public void contactLName(String id, String lastName) throws Exception {
    searchForContact(id).contactLName(lastName);
  }

  public void contactPhoneNum(String id, String phoneNumber)
      throws Exception {
    searchForContact(id).contactPhoneNum(phoneNumber);
  }

  public void contactAddress(String id, String address) throws Exception {
    searchForContact(id).contactAddress(address);
  }

  protected List<Contact> getContactList(){
	  return contactList; 
	  }

  private String newUniqueId() {
    return newUniqueId = UUID.randomUUID().toString().substring(
               0, Math.min(toString().length(), 10));
  }

  private Contact searchForContact(String id) throws Exception {
    int index = 0;
    while (index < contactList.size()) {
      if (id.equals(contactList.get(index).getID())) {
        return contactList.get(index);
      }
      index++;
    }
    throw new Exception("The Task does not exist!");
  }
}
