import Api.Model.Animal;
import Api.Service.CreateAnimalService;
import Exception.InvalidAnimalException;
import Model.AnimalClasses.Pets.Cat;
import Model.AnimalClasses.Pets.Dog;
import Model.AnimalClasses.Predators.Shark;
import Model.AnimalClasses.Predators.Wolf;
import Repository.AnimalRepositoryImpl;
import Service.SearchServiceImpl;

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
                CreateAnimalService.super.createAnimals();
                return null;
            }
        };
        //createAnimalService.createAnimals();
        //new CreateAnimalServiceImpl().createAnimals();
        //new CreateAnimalServiceImpl().createAnimals(5);

        try {
            SearchServiceImpl searchService = new SearchServiceImpl();
            AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();
            Dog dog = new Dog("Немецкая овчарка", "Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2016, 10, 6));
            Wolf wolf = new Wolf("Серый Волк", "Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
            Cat cat = new Cat("Киса");
            Cat cat1 = new Cat("Киса");
            Cat cat2 = new Cat("Багира");
            Cat cat3 = new Cat("Багира");
            Cat cat4 = new Cat("Багира");
            Shark shark = new Shark("Зубастик");
            Shark shark2 = new Shark("Зубастик");
            List<Animal> animalList = new ArrayList<>();
            animalList.add(shark);
            animalList.add(cat3);
            animalList.add(cat2);
            animalList.add(cat1);
            animalList.add(cat);
            animalList.add(cat4);
            animalList.add(shark2);
            System.out.println(animalRepository.findDuplicate(animalList));
            //animalList.add(dog);
            //animalList.add(wolf);
            //animalList.add(cat);
            //System.out.println(animalRepository.findOlderAnimal(animalList,6));
            //System.out.println(animalRepository.findLeapYearNames(animalList));
            //searchService.checkLeapYearAnimal(dog);
            //searchService.checkLeapYearAnimal(wolf);
            //searchService.checkLeapYearAnimal(cat);
        } catch (Exception e) {
            throw new InvalidAnimalException("Работа метода завершилась ошибкой:" + e);
        }
    }
}