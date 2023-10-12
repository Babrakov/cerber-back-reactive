package ru.infoza.cerberback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.infoza.cerberback.model.Person;
import ru.infoza.cerberback.repository.PersonRepository;
import ru.infoza.cerberback.service.PersonService;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonsController {

    private final PersonService personService;

    @Autowired
    public PersonsController(PersonService personService,
                             PersonRepository personRepository) {
        this.personService = personService;
    }

    @GetMapping
    public Flux<Person> getAllUsers() {
        return personService.findAllPersons();
    }

    @GetMapping("/{id}")
    public Mono<Person> getUserById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PostMapping
    public Mono<Person> createUser(@RequestBody Person person) {
        return personService.savePerson(person);
    }

    @PutMapping("/{id}")
    public Mono<Person> updateUser(@PathVariable Long id, @RequestBody Person person) {
        return personService.getPersonById(id)
                .flatMap(existingPerson -> {
                    existingPerson.setSurname(person.getSurname());
                    existingPerson.setName(person.getName());
                    existingPerson.setPatronymic(person.getPatronymic());
                    existingPerson.setBorn(person.getBorn());
                    return personService.savePerson(existingPerson);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable Long id) {
        return personService.deletePerson(id);
    }
}
