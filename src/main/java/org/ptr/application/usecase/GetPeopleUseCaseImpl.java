package org.ptr.application.usecase;

import org.ptr.domain.entity.People;
import org.ptr.domain.usecase.UseCase;
import org.ptr.infrastructure.client.PeopleApiClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Use case implementation for getting people data.
 * Demonstrates chaining external API calls using flatMap in a reactive way.
 */
@Service
public class GetPeopleUseCaseImpl implements UseCase<String, People> {

    private final PeopleApiClient peopleApiClient;

    public GetPeopleUseCaseImpl(PeopleApiClient peopleApiClient) {
        this.peopleApiClient = peopleApiClient;
    }

    @Override
    public Mono<People> execute(String input) {
        // Chain of external API calls with flatMap
        // 1. Fetch a random person
        // 2. Fetch a person by the nationality from step 1
        // 3. Fetch a person by the gender from step 2
        return peopleApiClient.fetchRandomPerson()
                .flatMap(firstPerson ->
                    peopleApiClient.fetchPersonByNationality(firstPerson.getNationality())
                )
                .flatMap(secondPerson ->
                    peopleApiClient.fetchPersonByGender(secondPerson.getGender())
                );
    }
}