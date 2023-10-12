package ru.infoza.cerberback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.infoza.cerberback.model.Person;
import ru.infoza.cerberback.repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Flux<Person> findAllPersons() {
        return personRepository.findAll();
    }

    public Mono<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Mono<Person> savePerson(Person person) {
        return personRepository.save(person);
    }

    public Mono<Void> deletePerson(Long id) {
        return personRepository.deleteById(id);
    }
}
