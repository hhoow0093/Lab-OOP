package Tugas;
import java.util.*;
public class PhoneBook {
    private ContactInfo owner;
    private ArrayList<ContactInfo> contacts = new ArrayList<>();

    public PhoneBook(ContactInfo owner) {
        this.owner = owner;
    }

    public ContactInfo getOwner() {
        return this.owner;
    }

    public void addContact(ContactInfo person) {
        contacts.add(person);
    }

    public ContactInfo findcontactByname(String name) {
        ContactInfo choosen;
        for (int i = 0; i < contacts.size(); i++) {
            if (name == contacts.get(i).getFname() || name == contacts.get(i).getLname()) {
                choosen = contacts.get(i);
                return choosen;
            }
        }
        choosen = new ContactInfo("NOT FOUND ", "NOT FOUND", "NOT FOUND", "NOT FOUND");
        return choosen;
    }

    public ArrayList<ContactInfo> findContactsByName(String name) {
        ArrayList<ContactInfo> match = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            if (name == contacts.get(i).getFname() || name == contacts.get(i).getLname()) {
                match.add(contacts.get(i));
            }
        }
        return match;
    }

}
