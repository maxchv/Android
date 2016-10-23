package ua.dp.itstep.listdemo;

/**
 * Created by max on 23.10.2016.
 */
public class User {
    private String firstName;
    private String lastName;
    private String phone;
    private int photo;

    public User(String firstName, String lastName, String phone, int photo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.setPhoto(photo);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
