package Service;

import Model.Interface.Animal;
import Service.Exception.InvalidAnimalBirthDateException;
import Service.Exception.InvalidAnimalException;
import Service.Interface.SearchService;

import java.time.LocalDate;

/**
 * Класс SearchServiceImpl, реализует {@link SearchService}.
 */
public class SearchServiceImpl implements SearchService {
    @Override
    public String checkLeapYearAnimal(Animal animal) throws InvalidAnimalBirthDateException {
        String outputMessage;
        if (animal != null) {
            LocalDate animalBirthDate = animal.getBirthDate();
            if (animalBirthDate != null) {
                outputMessage = animal.getName();

                if (animalBirthDate.isLeapYear()) {
                    outputMessage += " был рожден в високосный год";
                } else {
                    outputMessage += " не был рожден в високосный год";
                }
                System.out.println(outputMessage);
            } else
                throw new InvalidAnimalBirthDateException("У животного " + animal.getBreed() + " не указана дата его рождения!");
        } else throw new InvalidAnimalException("На вход пришло некорректный объект животного! " + LocalDate.now());
        return outputMessage;
    }
}
