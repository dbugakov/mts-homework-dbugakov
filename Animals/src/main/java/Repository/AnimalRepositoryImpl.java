package Repository;

import Api.Model.Animal;
import Api.Repository.AnimalRepository;
import Exception.InvalidAnimalBirthDateException;
import Service.SearchServiceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Класс AnimalRepositoryImpl, реализует {@link AnimalRepository}.
 */
public class AnimalRepositoryImpl implements AnimalRepository {

    /**
     * Функция получения HashMap с животными, которые родились в високосный год
     * Переопределён из {@link AnimalRepository}
     * @param animalList список животных
     * @return HashMap, где ключ - название класса + поле name, значение - поле дата рождения
     */
    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animalList) {
        SearchServiceImpl searchService = new SearchServiceImpl();
        return animalList.stream()
                .filter(animal -> {
                    try {
                        return searchService.checkLeapYearAnimal(animal);
                    } catch (InvalidAnimalBirthDateException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toMap(Animal -> Animal.getClass().getSimpleName() + " " + Animal.getName(), Animal::getBirthDate));
    }

    /**
     * Функция получения HashMap с животными, которые старше параметра age
     * Если ни одного животного с указанным годом нет, ищет самого старшего
     * Переопределён из {@link AnimalRepository}
     * @param animalList список животных
     * @param age целевой возраст
     * @return HashMap, где ключ - экземпляр животного, значение - возраст животного
     */
    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animalList, int age) {
        Map<Animal, Integer> resultMap = animalList.stream()
                .filter(Animal -> Period.between(Animal.getBirthDate(), LocalDate.now()).getYears() > age)
                .collect(Collectors.toMap(Function.identity(), animal -> (int) findAnimalAge(animal)));
        if (resultMap.isEmpty()) {
            resultMap = animalList.stream()
                    .sorted(Comparator.naturalOrder())
                    .limit(1)
                    .collect(Collectors.toMap(Function.identity(), animal -> (int) findAnimalAge(animal)));
        }
        return resultMap;
    }

    /**
     * Функция получения HashMap с животными, у которых есть дубликаты
     * Переопределён из {@link AnimalRepository}
     * @param animalList список животных
     * @return HashMap, где ключ - название класса, значение - список дубликатов
     */
    @Override
    public Map<String, List<Animal>> findDuplicate(List<Animal> animalList) {
        return animalList.stream()
                .collect(Collectors.groupingBy(Function.identity()))
                .values().stream()
                .filter(animals -> animals.size() > 1)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(animal -> animal.getClass().getSimpleName()));
    }

    /**
     * Функция получения среднего возраста из списка животных.
     * Ничего не возвращает печатает на экран.
     * Переопределён из {@link AnimalRepository}
     * @param animalList список животных
     */
    @Override
    public void findAverageAge(List<Animal> animalList) {
        System.out.println("Средний возраст животных равен = " + animalList.stream()
                .mapToDouble(this::findAnimalAge)
                .average()
                .orElse(Double.NaN));
    }

    /**
     * Функция получения списка с животными, возраст которых >5 лет и стоимость выше средней.
     * Переопределён из {@link AnimalRepository}
     * @param animalList список животных
     * @return List - список имён, отсортированный по дате рождения (по возрастанию)
     */
    @Override
    public List<String> findOldAndExpensive(List<Animal> animalList) {
        double averageCost = animalList.stream()
                .mapToDouble(Animal::getCost)
                .average()
                .orElse(Double.NaN);
        return animalList.stream()
                .filter(Animal -> findAnimalAge(Animal) > 5 && Animal.getCost() > averageCost)
                .sorted(Comparator.naturalOrder())
                .map(Animal::getName)
                .collect(Collectors.toList());
    }

    /**
     * Функция получения списка 3-х животных с самой низкой ценой.
     * Переопределён из {@link AnimalRepository}
     * @param animalList список животных
     * @return List - список имён, отсортированный в обратном алфавитном порядке
     */
    @Override
    public List<String> findMinConstAnimals(List<Animal> animalList) {
        return animalList.stream()
                .sorted(Comparator.comparing(Animal::getCost))
                .limit(3)
                .map(Animal::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    private double findAnimalAge(Animal animal) {
        return Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
    }
}
