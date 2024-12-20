package org.example.demo_jpa_repositories.repository;

import org.example.demo_jpa_repositories.entity.Persons;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends CrudRepository<Persons, Integer> {
    // Метод для получения всех Persons по городу
    List<Persons> getPersonsByCity(String city);

    // Метод для получения Persons по возрасту, меньше указанного, и сортировка по возрастанию
    List<Persons> findByAgeLessThanOrderByAgeAsc(int age);

    // Метод для получения Persons по имени и фамилии, возвращающий Optional
    Optional<Persons> findByNameAndSurname(String name, String surname);
}

