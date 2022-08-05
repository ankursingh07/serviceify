package Models;

import java.io.Serializable;

public class ServiceModel implements Serializable {
    String title,address,phone,availability, display,price;
    int review;

    public ServiceModel(String title, String address, String phone, String availability, String display, String price, int review) {
        this.title = title;
        this.address = address;
        this.phone = phone;
        this.availability = availability;
        this.display = display;
        this.price = price;
        this.review = review;
    }

    public ServiceModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }
}
