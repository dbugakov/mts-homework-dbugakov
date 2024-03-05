package Service;

import Model.Asbtract.AbstractAnimal;
import Service.Interface.CreateAnimalService;

/**
 * Класс CreateAnimalServiceImpl, реализует {@link CreateAnimalService}.
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {

    /**
     * Функция создания десяти уникальных животных.
     * Переопределён из {@link CreateAnimalService}.
     * Ничего не возвращает, выводит результат на экран
     */
    @Override
    public void createAnimals() {
        System.out.println("createAnimals - do while");
        int i = 0;
        do {
            AbstractAnimal.getRandomAnimal();
            i++;
        } while (i < 10);
    }

    /**
     * Функция создания уникальных животных в заданном количестве.
     * Перегружен из метода {@link CreateAnimalServiceImpl#createAnimals}.
     * Ничего не возвращает, выводит результат на экран
     */
    public void createAnimals(int AnimalCount) {
        System.out.println("createAnimals - for");
        for (int i = 0; i < AnimalCount; i++) {
            AbstractAnimal.getRandomAnimal();
        }
    }
}
