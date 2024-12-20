package org.example.demo_jpa_repositories.config;

import org.example.demo_jpa_repositories.entity.Persons;
import org.example.demo_jpa_repositories.repository.PersonsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PersonsRepository personsRepository;

    public DataInitializer(final PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    public void saveIfNotExists(Persons person) {
        if (personsRepository.getPersonsByCity(person.getCityOfResidence()).isEmpty()) {
            personsRepository.save(person);
        }
    }


    @Override
    public void run(String... args) throws Exception {
       saveIfNotExists(new Persons("Olga", "Karpova", 30, "12345678906", "Moscow"));
       saveIfNotExists(new Persons("Dmitry", "Ivanov", 25, "09876543211", "Los Angeles"));
       saveIfNotExists(new Persons("Ivan", "Sergeev", 21, "09876544292", "Moscow"));
       saveIfNotExists(new Persons("Svetlana","Medvedeva",15,"15787644321","Saratov"));
    }
}
