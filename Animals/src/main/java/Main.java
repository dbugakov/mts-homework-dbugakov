import Api.Model.Animal;
import Api.Service.CreateAnimalService;
import Exception.InvalidAnimalException;
import Model.Cat;
import Model.Dog;
import Model.Shark;
import Model.Wolf;
import Repository.AnimalRepositoryImpl;
import Service.CreateAnimalServiceImpl;
import Service.SearchServiceImpl;
import Util.ResultReader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Класс Main, запускает программу.
 */
public class Main {

    /**
     * Функция запуска программы.
     * Ничего не возвращает, выводит результат на экран
     */
    public static void main(String[] args) {

        CreateAnimalService createAnimalService = new CreateAnimalService() {

            @Override
            public Map<String, List<Animal>> createAnimals() {
                return CreateAnimalService.super.createAnimals();
            }
        };
        CreateAnimalServiceImpl createAnimalService1 = new CreateAnimalServiceImpl();
        createAnimalService1.createAnimals();
        ResultReader.printFileCntAllLines("Animals/src/main/resources/animals/logData.txt");
        try {
            SearchServiceImpl searchService = new SearchServiceImpl();
            AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();
            List<Animal> animalList = getAnimalList();
            System.out.println(animalRepository.findOlderAnimal(animalList, 3));
        } catch (Exception e) {
            throw new InvalidAnimalException("Работа метода завершилась ошибкой:" + e);
        }
    }

    private static List<Animal> getAnimalList() {
        Cat dog2 = new Cat("Улисей", 9999.99, "Не кусает за бочок", LocalDate.of(2011, 1, 6));
        Dog dog = new Dog("Ялисей", 999.99, "Не кусает за бочок", LocalDate.of(2016, 10, 6));
        Wolf wolf = new Wolf("Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        Cat dog3 = new Cat("Елисей", 777.77, "Не кусает за бочок", LocalDate.of(2011, 1, 6));

        Cat cat = new Cat("Киса");
        Cat cat1 = new Cat("Киса");
        Cat cat2 = new Cat("Багира");
        Cat cat3 = new Cat("Багира");
        Cat cat4 = new Cat("Багира");
        Shark shark = new Shark("Зубастик");
        Shark shark2 = new Shark("Зубастик");
        List<Animal> animalList = new ArrayList<>();
        animalList.add(dog);
        animalList.add(wolf);
        animalList.add(dog2);
        animalList.add(dog3);
        return animalList;
    }
}