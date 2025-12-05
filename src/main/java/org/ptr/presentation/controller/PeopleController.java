package org.ptr.presentation.controller;

import org.ptr.application.usecase.GetPeopleUseCaseImpl;
import org.ptr.domain.entity.People;
import org.ptr.presentation.dto.PeopleRequest;
import org.ptr.presentation.dto.PeopleResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * REST controller for People operations using WebFlux reactive approach.
 */
@RestController
@RequestMapping("/api/people")
public class PeopleController {

    private final GetPeopleUseCaseImpl getPeopleUseCase;

    public PeopleController(GetPeopleUseCaseImpl getPeopleUseCase) {
        this.getPeopleUseCase = getPeopleUseCase;
    }

    @GetMapping
    public Mono<PeopleResponse> getPeople() {
        return getPeopleUseCase.execute(null)
                .map(this::mapToResponse)
                .onErrorResume(error -> {
                    PeopleResponse errorResponse = new PeopleResponse();
                    errorResponse.setStatus("ERROR");
                    errorResponse.setMessage(error.getMessage());
                    return Mono.just(errorResponse);
                });
    }

    @PostMapping
    public Mono<PeopleResponse> getPeopleByFilter(@RequestBody PeopleRequest request) {
        return getPeopleUseCase.execute(request.getNationality())
                .map(this::mapToResponse)
                .onErrorResume(error -> {
                    PeopleResponse errorResponse = new PeopleResponse();
                    errorResponse.setStatus("ERROR");
                    errorResponse.setMessage(error.getMessage());
                    return Mono.just(errorResponse);
                });
    }

    private PeopleResponse mapToResponse(People people) {
        PeopleResponse response = new PeopleResponse();
        response.setName(people.getName());
        response.setEmail(people.getEmail());
        response.setGender(people.getGender());
        response.setNationality(people.getNationality());
        response.setPhone(people.getPhone());
        response.setStatus("SUCCESS");
        return response;
    }
}