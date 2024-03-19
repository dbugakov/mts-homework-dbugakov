package Api.Repository;

import Api.Model.Animal;
import Exception.InvalidAnimalBirthDateException;
import Repository.AnimalRepositoryImpl;
import Service.SearchServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * SearchService, реализован в {@link AnimalRepositoryImpl}.
 */
public interface AnimalRepository {
    Map<String, LocalDate> findLeapYearNames(List<Animal> animalList) throws InvalidAnimalBirthDateException;

    Map<Animal, Integer> findOlderAnimal(List<Animal> animalList, int age);

    Map<String, Integer> findDuplicate(List<Animal> animalList);
}
