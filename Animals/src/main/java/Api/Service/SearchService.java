package Api.Service;

import Api.Model.Animal;
import Exception.InvalidAnimalBirthDateException;
import Service.SearchServiceImpl;

/**
 * SearchService, реализован в {@link SearchServiceImpl}.
 */

public interface SearchService {
    boolean checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException;
}
