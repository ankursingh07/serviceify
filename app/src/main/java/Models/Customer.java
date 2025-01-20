package Models;

public class Customer {
    public String name,email,phoneNumber,address,profileUrl;

    public Customer(String name, String email, String phoneNumber, String address, String profileUrl) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profileUrl = profileUrl;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getAddress() {
        return address;
    }

    public String getProfileUrl() {
        return profileUrl;
    }
}
