package org.ptr.infrastructure.repository;

import org.ptr.domain.entity.People;
import reactor.core.publisher.Mono;

/**
 * Repository interface for People data persistence.
 * Implementations can use Spring Data R2DBC or other reactive data access technologies.
 */
public interface PeopleRepository {

    Mono<People> findById(String id);

    Mono<People> save(People people);

    Mono<Void> deleteById(String id);
}
