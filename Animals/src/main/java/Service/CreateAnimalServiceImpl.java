package Service;

import Api.Model.Animal;
import Api.Service.CreateAnimalService;
import Model.AbstractAnimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс CreateAnimalServiceImpl, реализует {@link CreateAnimalService}.
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {
    Map<String, List<Animal>> resultMap;
    Animal animal;

    /**
     * Функция создания десяти уникальных животных.
     * Переопределён из {@link CreateAnimalService}.
     * @return HashMap, где ключ - название класса, значение - массив Animal
     */
    @Override
    public Map<String, List<Animal>> createAnimals() {
        System.out.println("createAnimals - do while");
        resultMap = new HashMap<>();
        int i = 0;
        do {
            fillResultMap();
            i++;
        } while (i < 10);
        System.out.println(resultMap);
        return resultMap;
    }

    /**
     * Функция создания уникальных животных в заданном количестве.
     * Перегружен из метода {@link CreateAnimalServiceImpl#createAnimals}.
     * @return HashMap, где ключ - название класса, значение - массив Animal
     */
    public Map<String, List<Animal>> createAnimals(int animalCount) {
        System.out.println("createAnimals - for");
        resultMap = new HashMap<>();
        for (int i = 0; i < animalCount; i++) {
            fillResultMap();
        }
        System.out.println(resultMap);
        return resultMap;
    }

    private void fillResultMap() {
        animal = AbstractAnimal.getRandomAnimal();
        if (resultMap.containsKey(animal.getClass().getSimpleName())) {
            resultMap.get(animal.getClass().getSimpleName()).add(animal);
        } else {
            resultMap.put(animal.getClass().getSimpleName(), new ArrayList<>());
            resultMap.get(animal.getClass().getSimpleName()).add(animal);
        }
    }
}
