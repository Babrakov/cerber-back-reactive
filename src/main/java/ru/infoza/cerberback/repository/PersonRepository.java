package ru.infoza.cerberback.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.infoza.cerberback.model.Person;


@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {
}
