package vn.edu.ntu.ontapbai2.model;

public class contact {
    int id;
    String name;
    String birthday;
    String phone;
    String Address;

    public contact(int id, String name, String birthday, String phone, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        Address = address;
    }

    public contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
