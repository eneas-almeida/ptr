package org.ptr.presentation.dto;

/**
 * Response DTO for People API endpoints.
 */
public class PeopleResponse {

    private String name;
    private String email;
    private String gender;
    private String nationality;
    private String phone;
    private String status;
    private String message;

    public PeopleResponse() {
    }

    public PeopleResponse(String name, String email, String gender, String nationality, String phone, String status) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.nationality = nationality;
        this.phone = phone;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}