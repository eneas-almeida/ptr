package org.ptr.infrastructure.client.dto;

import java.util.List;

/**
 * Root response from RandomUser API.
 */
public class RandomUserResponse {

    private List<RandomUserResult> results;
    private RandomUserInfo info;

    public List<RandomUserResult> getResults() {
        return results;
    }

    public void setResults(List<RandomUserResult> results) {
        this.results = results;
    }

    public RandomUserInfo getInfo() {
        return info;
    }

    public void setInfo(RandomUserInfo info) {
        this.info = info;
    }
}