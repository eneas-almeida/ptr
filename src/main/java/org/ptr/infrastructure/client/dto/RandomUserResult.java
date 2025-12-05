package org.ptr.infrastructure.client.dto;

/**
 * Individual user result from RandomUser API.
 */
public class RandomUserResult {

    private String gender;
    private RandomUserName name;
    private String email;
    private String phone;
    private String nat;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public RandomUserName getName() {
        return name;
    }

    public void setName(RandomUserName name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }
}