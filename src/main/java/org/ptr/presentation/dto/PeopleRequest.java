package org.ptr.presentation.dto;

/**
 * Request DTO for People API endpoints.
 */
public class PeopleRequest {

    private String nationality;
    private String gender;

    public PeopleRequest() {
    }

    public PeopleRequest(String nationality, String gender) {
        this.nationality = nationality;
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}