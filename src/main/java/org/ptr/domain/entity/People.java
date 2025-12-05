package org.ptr.domain.entity;

/**
 * Domain entity representing a person.
 */
public class People extends BaseEntity {

    private String name;
    private String email;
    private String gender;
    private String nationality;
    private String phone;

    public People() {
        super();
    }

    public People(String name, String email, String gender, String nationality, String phone) {
        super();
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.nationality = nationality;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}