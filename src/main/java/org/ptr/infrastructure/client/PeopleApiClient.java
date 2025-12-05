package org.ptr.infrastructure.client;

import org.ptr.domain.entity.People;
import org.ptr.infrastructure.client.dto.RandomUserResponse;
import org.ptr.infrastructure.client.dto.RandomUserResult;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Client for making external API calls to fetch people data.
 * Uses RandomUser API (https://randomuser.me) as a real data source.
 */
@Component
public class PeopleApiClient {

    private final WebClient webClient;
    private static final String RANDOM_USER_API = "https://randomuser.me/api/";

    public PeopleApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(RANDOM_USER_API).build();
    }

    /**
     * Fetches a random person from RandomUser API.
     * This is the first call in the chain.
     */
    public Mono<People> fetchRandomPerson() {
        return webClient.get()
                .uri("?results=1")
                .retrieve()
                .bodyToMono(RandomUserResponse.class)
                .flatMap(this::parsePeopleFromRandomUser)
                .onErrorResume(error -> {
                    return Mono.error(new RuntimeException("Error fetching random person", error));
                });
    }

    /**
     * Fetches a person by nationality.
     * This can be used as a second call in the chain.
     */
    public Mono<People> fetchPersonByNationality(String nationality) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("nat", nationality)
                        .queryParam("results", 1)
                        .build())
                .retrieve()
                .bodyToMono(RandomUserResponse.class)
                .flatMap(this::parsePeopleFromRandomUser)
                .onErrorResume(error -> {
                    return Mono.error(new RuntimeException("Error fetching person by nationality", error));
                });
    }

    /**
     * Fetches a person by gender.
     * This can be used as a third call in the chain.
     */
    public Mono<People> fetchPersonByGender(String gender) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("gender", gender.toLowerCase())
                        .queryParam("results", 1)
                        .build())
                .retrieve()
                .bodyToMono(RandomUserResponse.class)
                .flatMap(this::parsePeopleFromRandomUser)
                .onErrorResume(error -> {
                    return Mono.error(new RuntimeException("Error fetching person by gender", error));
                });
    }

    /**
     * Parses the RandomUser API response to our People entity.
     */
    private Mono<People> parsePeopleFromRandomUser(RandomUserResponse response) {
        try {
            if (response.getResults() != null && !response.getResults().isEmpty()) {
                RandomUserResult user = response.getResults().get(0);

                People people = new People();
                people.setName(user.getName().getFullName());
                people.setEmail(user.getEmail());
                people.setGender(user.getGender());
                people.setNationality(user.getNat());
                people.setPhone(user.getPhone());

                return Mono.just(people);
            }
            return Mono.error(new RuntimeException("No results found in API response"));
        } catch (Exception e) {
            return Mono.error(new RuntimeException("Error parsing API response", e));
        }
    }
}