package org.example.demo_jpa_repositories.controller;

import org.example.demo_jpa_repositories.entity.Persons;
import org.example.demo_jpa_repositories.repository.PersonsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonsController {

    private final PersonsRepository personsRepository;

    public PersonsController(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    // Получить всех Persons по городу
    @GetMapping("/city/{city}")//http://localhost:8080/api/persons/city/Moscow

    public List<Persons> getPersonsByCity(@PathVariable String city) {
        return personsRepository.getPersonsByCity(city);
    }

    // Получить Persons по возрасту, меньше указанного
    @GetMapping("/age/less-than/{age}")//http://localhost:8080/api/persons/age/less-than/20

    public List<Persons> getPersonsYoungerThan(@PathVariable int age) {
        return personsRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    // Получить Persons по имени и фамилии
    @GetMapping("/name/{name}/surname/{surname}")//http://localhost:8080/api/persons/name/Olga/surname/Karpova
    public ResponseEntity<Persons> getPersonByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
        Optional<Persons> person = personsRepository.findByNameAndSurname(name, surname);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

