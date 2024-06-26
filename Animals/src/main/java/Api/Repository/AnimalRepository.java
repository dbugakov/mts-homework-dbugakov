package Api.Repository;

import Api.Model.Animal;
import Exception.InvalidAnimalBirthDateException;
import Repository.AnimalRepositoryImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * SearchService, реализован в {@link AnimalRepositoryImpl}.
 */
public interface AnimalRepository {
    Map<String, LocalDate> findLeapYearNames(List<Animal> animalList) throws InvalidAnimalBirthDateException;

    Map<Animal, Integer> findOlderAnimal(List<Animal> animalList, int age) throws IOException;

    Map<String, List<Animal>> findDuplicate(List<Animal> animalList);

    double findAverageAge(List<Animal> animalList);

    List<String> findOldAndExpensive(List<Animal> animalList);

    List<String> findMinConstAnimals(List<Animal> animalList);
}
