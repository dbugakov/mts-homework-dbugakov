import Model.AnimalClasses.Pets.Cat;
import Model.AnimalClasses.Pets.Dog;
import Model.AnimalClasses.Predators.Wolf;
import Service.CreateAnimalServiceImpl;
import Service.Exception.InvalidAnimalException;
import Service.Interface.CreateAnimalService;
import Service.SearchServiceImpl;

import java.time.LocalDate;

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
            public void createAnimals() {
                CreateAnimalService.super.createAnimals();
            }
        };
        createAnimalService.createAnimals();
        new CreateAnimalServiceImpl().createAnimals();
        new CreateAnimalServiceImpl().createAnimals(5);

        try {
            SearchServiceImpl searchService = new SearchServiceImpl();
            Dog dog = new Dog("Немецкая овчарка", "Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2016, 10, 6));
            Wolf wolf = new Wolf("Серый Волк", "Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
            Cat cat = new Cat();
            System.out.println(wolf.getBirthDate());
            searchService.checkLeapYearAnimal(dog);
            searchService.checkLeapYearAnimal(wolf);
            //searchService.checkLeapYearAnimal(cat);
        } catch (Exception e) {
            throw new InvalidAnimalException("Работа метода завершилась ошибкой:" + e);
        }
    }
}