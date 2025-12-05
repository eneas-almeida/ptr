package org.ptr.domain.usecase;

import reactor.core.publisher.Mono;

/**
 * Base interface for use cases following Clean Architecture principles.
 * Use cases represent business logic operations.
 *
 * @param <I> Input type
 * @param <O> Output type
 */
public interface UseCase<I, O> {

    /**
     * Executes the use case with the given input.
     * Returns a Mono for reactive processing with WebFlux.
     *
     * @param input the input data
     * @return Mono containing the result
     */
    Mono<O> execute(I input);
}