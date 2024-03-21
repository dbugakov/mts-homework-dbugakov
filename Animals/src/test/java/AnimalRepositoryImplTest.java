import Api.Model.Animal;
import Exception.InvalidAnimalBirthDateException;
import Model.AnimalClasses.Pets.Cat;
import Model.AnimalClasses.Pets.Dog;
import Model.AnimalClasses.Predators.Shark;
import Model.AnimalClasses.Predators.Wolf;
import Repository.AnimalRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalRepositoryImplTest {
    List<Animal> animalList;
    AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();

    @DisplayName("Кейс, когда хотя бы у одного из животных год високостный")
    @Test
    void findLeapYearNamesPositive() throws InvalidAnimalBirthDateException {
        animalList = new ArrayList<>();
        Dog dog = new Dog("Немецкая овчарка", "Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2016, 10, 6));
        Wolf wolf = new Wolf("Серый Волк", "Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        animalList.add(dog);
        animalList.add(wolf);
        assertFalse(animalRepository.findLeapYearNames(animalList).isEmpty());
    }

    @DisplayName("Кейс, когда никого из животных год високостный")
    @Test
    void findLeapYearNamesNegative() throws InvalidAnimalBirthDateException {
        animalList = new ArrayList<>();
        Dog dog = new Dog("Немецкая овчарка", "Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2017, 10, 6));
        Wolf wolf = new Wolf("Серый Волк", "Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        animalList.add(dog);
        animalList.add(wolf);
        assertTrue(animalRepository.findLeapYearNames(animalList).isEmpty());
    }

    @DisplayName("Кейс, когда найдены животные старше указанного года")
    @Test
    void findOlderAnimalPositive() {
        animalList = new ArrayList<>();
        Dog dog = new Dog("Немецкая овчарка", "Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2016, 10, 6));
        Wolf grayWolf = new Wolf("Серый Волк", "Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        Wolf whiteWolf = new Wolf("Белый Волк", "Шарик", 777.77, "Замыкает стаю", LocalDate.of(2023, 3, 17));
        animalList.add(dog);
        animalList.add(grayWolf);
        animalList.add(whiteWolf);
        assertEquals(animalRepository.findOlderAnimal(animalList, 2).size(), 2);
    }

    @DisplayName("Кейс, когда найдены животные старше указанного года, выводится самый старший")
    @Test
    void findOlderAnimalNegative() {
        animalList = new ArrayList<>();
        Dog dog = new Dog("Немецкая овчарка", "Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2017, 10, 6));
        Wolf wolf = new Wolf("Серый Волк", "Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        animalList.add(dog);
        animalList.add(wolf);
        assertEquals(animalRepository.findOlderAnimal(animalList, 10).size(), 1);
    }

    @DisplayName("Кейс, когда хотя бы у одного из животных год високостный")
    @Test
    void findDuplicatePositive() {
        animalList = new ArrayList<>();
        Cat cat = new Cat("Киса");
        Cat cat1 = new Cat("Киса");
        Cat cat2 = new Cat("Багира");
        Cat cat3 = new Cat("Багира");
        Cat cat4 = new Cat("Багира");
        Shark shark = new Shark("Зубастик");
        animalList.add(shark);
        animalList.add(cat3);
        animalList.add(cat2);
        animalList.add(cat1);
        animalList.add(cat);
        animalList.add(cat4);
        assertFalse(animalRepository.findDuplicate(animalList).isEmpty());
    }

    @DisplayName("Кейс, когда никого из животных год високостный")
    @Test
    void findDuplicateNegative() {
        animalList = new ArrayList<>();
        Dog dog = new Dog("Немецкая овчарка", "Елисей", 999.99, "Не кусает за бочок", LocalDate.of(2017, 10, 6));
        Wolf wolf = new Wolf("Серый Волк", "Мухтар", 888.88, "Кусает за бочок", LocalDate.of(2021, 3, 17));
        animalList.add(dog);
        animalList.add(wolf);
        assertTrue(animalRepository.findDuplicate(animalList).isEmpty());
    }

}
