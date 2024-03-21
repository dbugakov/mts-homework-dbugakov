package Repository;

import Api.Model.Animal;
import Api.Repository.AnimalRepository;
import Exception.InvalidAnimalBirthDateException;
import Model.Asbtract.AbstractAnimal;
import Service.SearchServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс AnimalRepositoryImpl, реализует {@link AnimalRepository}.
 */
public class AnimalRepositoryImpl implements AnimalRepository {

    /**
     * Функция получения HashMap с животными, которые родились в високосный год
     * Переопределён из {@link AnimalRepository}
     * @return HashMap, где ключ - название класса + поле name, значение - поле дата рождения
     */
    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animalList) throws InvalidAnimalBirthDateException {
        SearchServiceImpl searchService = new SearchServiceImpl();
        Map<String, LocalDate> resultMap = new HashMap<>();
        for (Animal animal : animalList) {
            if (searchService.checkLeapYearAnimal(animal)) {
                resultMap.put(animal.getClass().getSimpleName() + " " + animal.getName(), animal.getBirthDate());
            }
        }
        return resultMap;
    }

    /**
     * Функция получения HashMap с животными, которые старше параметра age
     * Если ни одного животного с указанным годом нет, ищет самого старшего
     * Переопределён из {@link AnimalRepository}
     * @return HashMap, где ключ - экземпляр животного, значение - возраст животного
     */
    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animalList, int age) {
        Map<Animal, Integer> resultMap = new HashMap<>();
        int animalAge;
        for (Animal animal : animalList) {
            animalAge = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
            if (animalAge > age) {
                resultMap.put(animal, animalAge);
            }
        }
        if (resultMap.isEmpty()) {
            animalList.sort(Comparator.naturalOrder());
            resultMap.put(animalList.get(0), Period.between(animalList.get(0).getBirthDate(), LocalDate.now()).getYears());
        }
        return resultMap;
    }

    /**
     * Функция получения HashMap с животными, у которых есть дубликаты
     * Переопределён из {@link AnimalRepository}
     * @return HashMap, где ключ - название класса, значение - количество найденных дубликатов
     */
    @Override
    public Map<String, Integer> findDuplicate(List<Animal> animalList) {
        Map<String, Integer> resultMap = new HashMap<>();
        Map<Animal, Integer> frequencyMap = new HashMap<>();
        for (Animal animal : animalList) {
            frequencyMap.put(animal, frequencyMap.getOrDefault(animal, 0) + 1);
        }
        for (Animal animal : frequencyMap.keySet()) {
            if (frequencyMap.get(animal) != 1) {
                if (resultMap.containsKey(animal.getClass().getSimpleName())) {
                    var i = resultMap.get(animal.getClass().getSimpleName());
                    resultMap.put(animal.getClass().getSimpleName(), i + frequencyMap.get(animal));
                } else {
                    resultMap.put(animal.getClass().getSimpleName(), frequencyMap.get(animal));
                }
            }
        }
        return resultMap;
    }
}
