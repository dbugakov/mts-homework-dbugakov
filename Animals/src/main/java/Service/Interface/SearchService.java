package Service.Interface;

import Model.Interface.Animal;
import Service.Exception.InvalidAnimalBirthDateException;
import Service.SearchServiceImpl;

/**
 * SearchService, реализован в {@link SearchServiceImpl}.
 */

public interface SearchService {
    String checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException;
}
