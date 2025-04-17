package Tugas;

public class ContactInfo {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String country;

    public ContactInfo(String firstname, String lastName, String phoneNumber, String country) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }

    private String getName() {
        return this.firstName + " : " + this.lastName;
    }

    public String getContact() {
        return String.format(" %s : %s (:%s)", getName(), this.phoneNumber, this.country);
    }

    public String getFname() {
        return this.firstName;
    }

    public String getLname() {
        return this.lastName;
    }

    public boolean match(String Match) {
        boolean flag = false;
        if (Match == lastName || Match == firstName) {
            flag = true;
        }

        return flag;
    }

}
